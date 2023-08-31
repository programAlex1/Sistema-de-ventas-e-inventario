package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.repository.ICustomerRepository;
import com.ventasinventario.Libreria.domain.repository.IEmployeeRepository;
import com.ventasinventario.Libreria.domain.repository.ISaleRepository;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.domain.useCase.ISaleUseCase;
import com.ventasinventario.Libreria.exception.ResourceNotFoundException;
import com.ventasinventario.Libreria.exception.InsufficientStockException;
import com.ventasinventario.Libreria.util.SaleReceiptGenerator;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SaleService implements ISaleUseCase {

    private final IBookRepository iBookRepository;

    private final ISaleRepository iSaleRepository;

    private final IEmployeeRepository iEmployeeRepository;

    private final ICustomerRepository iCustomerRepository;
    private final SaleReceiptGenerator saleReceiptGenerator;
    @Override
    public List<SaleDtoResponse> findAll() {
        return iSaleRepository.findAll();
    }

    @Override
    public SaleDtoResponse save(SaleDtoRequest saleDtoRequest) {
        if(iEmployeeRepository.findById(saleDtoRequest.getIdEmployee()).isEmpty())
            throw new ResourceNotFoundException("Employee not found with ID " + saleDtoRequest.getIdEmployee() );

        if(iCustomerRepository.findById(saleDtoRequest.getIdCustomer()).isEmpty())
            throw new ResourceNotFoundException("Customer not found with ID " + saleDtoRequest.getIdCustomer());

        saleDtoRequest.setDate(new Date());
        saleDtoRequest.setTotal(saleDtoRequest.getBookList().stream().mapToDouble(details ->{
            BookDto bookDto = iBookRepository.findById(details.getIdBook()).orElseThrow(()->
                    new ResourceNotFoundException("Book not found with ID " + details.getIdBook()));
            details.setPrice(bookDto.getPrice());
            details.setTotal(bookDto.getPrice()*details.getQuantity());
            return details.getTotal();
        }).sum());

        saleDtoRequest.getBookList().forEach(book->
            iBookRepository.findById(book.getIdBook())
                    .ifPresent(bookUpdate -> {
                        if(book.getQuantity()>bookUpdate.getStock())
                            throw new InsufficientStockException();

                        iBookRepository.updateStockLess(bookUpdate.getId(),book.getQuantity());
                    })
        );


        return iSaleRepository.save(saleDtoRequest);
    }

    @Override
    public Optional<SaleDtoResponse> findById(Long id) {
        return iSaleRepository.findById(id);
    }

    @Override
    public List<SaleDtoResponse> findByCardIdCustomer(Long cardId) {
        return iSaleRepository.findByCardIdCustomer(cardId);
    }

    @Override
    public boolean delete(Long id) {
        Optional<SaleDtoResponse> saleDtoResponse= iSaleRepository.findById(id);
        if(saleDtoResponse.isEmpty())
            return false;

        saleDtoResponse.get().getBookList().forEach(book ->
                iBookRepository.findById(book.getIdBook()).ifPresent(
                        bookUpdate -> iBookRepository.updateStockMore(bookUpdate.getId(),book.getQuantity())
                ));
        iSaleRepository.delete(id);
        return true;


    }

    @Override
    public byte[] exportToPdf(Long id) throws JRException, FileNotFoundException {
        Optional<SaleDtoResponse> billDtoResponse = iSaleRepository.findById(id);
        if (billDtoResponse.isPresent())
           return saleReceiptGenerator.exportToPdf(billDtoResponse.get());

        throw new ResourceNotFoundException("Sale not found with ID " + id);
    }
}