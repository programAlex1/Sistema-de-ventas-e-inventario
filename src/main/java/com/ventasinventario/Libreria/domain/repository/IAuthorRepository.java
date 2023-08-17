package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface IAuthorRepository {

    List<AuthorDto> findAll();

    Optional<AuthorDto> findById(Long idAuthor);

    AuthorDto save(AuthorDto authorDto);

    void delete(Long idAuthor);

    Optional<AuthorDto> findByName(String name);
}
