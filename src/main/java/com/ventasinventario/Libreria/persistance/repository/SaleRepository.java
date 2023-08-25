package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import com.ventasinventario.Libreria.domain.repository.ISaleRepository;
import com.ventasinventario.Libreria.persistance.crud.IBillCrudRepository;
import com.ventasinventario.Libreria.persistance.crud.IBookCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.SaleEntity;
import com.ventasinventario.Libreria.persistance.mapper.ISaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SaleRepository implements ISaleRepository {
    private final IBillCrudRepository iBillCrudRepository;

    private final ISaleMapper iSaleMapper;
    private final IBookCrudRepository iBookCrudRepository;

    @Override
    public List<SaleDtoResponse> findAll() {
        return iSaleMapper.toSaleDtoResponseList(iBillCrudRepository.findAll());
    }

    @Override
    public SaleDtoResponse save(SaleDtoRequest saleDtoRequest) {
        SaleEntity bill = iSaleMapper.toSaleEntity(saleDtoRequest);
        bill.getBookList().forEach(books-> books.setBallot(bill));
        SaleEntity ballotSave= iBillCrudRepository.save(bill);
        SaleDtoResponse saleDtoResponse = iSaleMapper.toSaleDtoResponse(ballotSave);
        saleDtoResponse.getBookList().forEach(book->
            iBookCrudRepository.findById(book.getIdBook())
                    .ifPresent(book1 -> book.setNameBook(book1.getTitle()))
        );
        return saleDtoResponse;
    }

    @Override
    public Optional<SaleDtoResponse> findById(Long id) {
        return iBillCrudRepository.findById(id)
                .map(iSaleMapper::toSaleDtoResponse);
    }

    @Override
    public List<SaleDtoResponse> findByCardIdCustomer(Long cardId) {
        return iSaleMapper.toSaleDtoResponseList(iBillCrudRepository.findByIdCustomerCardId(cardId));
    }


}
