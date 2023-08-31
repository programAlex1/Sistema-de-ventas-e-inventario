package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;

import java.util.List;
import java.util.Optional;

public interface ISaleRepository {

    List<SaleDtoResponse> findAll();

    SaleDtoResponse save(SaleDtoRequest saleDtoRequest);

    Optional<SaleDtoResponse> findById(Long id);

    List<SaleDtoResponse> findByCardIdCustomer(Long cardId);

    void delete(Long id);
}
