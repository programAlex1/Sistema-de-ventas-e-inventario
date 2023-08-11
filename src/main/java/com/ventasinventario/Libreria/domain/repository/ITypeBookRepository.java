package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.TypeBookDto;

import java.util.List;
import java.util.Optional;

public interface ITypeBookRepository {
    List<TypeBookDto> findAll();

    Optional<TypeBookDto> findById(Long idBook);

    TypeBookDto save(TypeBookDto typeBookDto);

    void delete(Long idBook);

}
