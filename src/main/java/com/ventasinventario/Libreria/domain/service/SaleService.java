package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.repository.ISaleRepository;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.domain.useCase.ISaleUseCase;
import com.ventasinventario.Libreria.exception.SaleNotExistException;
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

    private final SaleReceiptGenerator saleReceiptGenerator;
    @Override
    public List<SaleDtoResponse> findAll() {
        return iSaleRepository.findAll();
    }

    @Override
    public SaleDtoResponse save(SaleDtoRequest saleDtoRequest) {
        saleDtoRequest.setDate(new Date());
        saleDtoRequest.setTotal(saleDtoRequest.getBookList().stream().mapToDouble(details ->{
            iBookRepository.findById(details.getIdBook()).ifPresent(bookDto -> {
                details.setPrice(bookDto.getPrice());
                details.setTotal(bookDto.getPrice()*details.getQuantity());
            });
            return details.getTotal();
        }).sum());

        saleDtoRequest.getBookList().forEach(book->
            iBookRepository.findById(book.getIdBook())
                    .ifPresent(bookUpdate -> {
                        if(book.getQuantity()>bookUpdate.getStock())
                            throw new InsufficientStockException();

                        iBookRepository.updateStock(bookUpdate.getId(),book.getQuantity());
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
    public byte[] exportToPdf(Long id) throws JRException, FileNotFoundException {
        Optional<SaleDtoResponse> billDtoResponse = iSaleRepository.findById(id);
        if (billDtoResponse.isPresent())
           return saleReceiptGenerator.exportToPdf(billDtoResponse.get());

        throw new SaleNotExistException();
    }
}