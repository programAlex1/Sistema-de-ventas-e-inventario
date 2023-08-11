package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.TypeBookDto;

import java.util.List;
import java.util.Optional;

public interface ITypeBookUseCase {
    List<TypeBookDto> findAll();

    Optional<TypeBookDto> findById(Long idBook);

    TypeBookDto save(TypeBookDto typeBookDto);

    Optional<TypeBookDto> update(TypeBookDto typeBookDto);

    boolean delete(Long idBook);
}
