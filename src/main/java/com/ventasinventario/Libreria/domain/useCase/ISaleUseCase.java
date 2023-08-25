package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.SaleDtoRequest;
import com.ventasinventario.Libreria.domain.dto.SaleDtoResponse;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface ISaleUseCase {

    List<SaleDtoResponse> findAll();


    SaleDtoResponse save(SaleDtoRequest saleDtoRequest);

    Optional<SaleDtoResponse> findById(Long id);

    List<SaleDtoResponse> findByCardIdCustomer(Long cardId);

    byte[] exportToPdf(Long id) throws JRException, FileNotFoundException;
}
