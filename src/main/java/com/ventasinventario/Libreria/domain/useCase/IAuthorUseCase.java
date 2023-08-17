package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface IAuthorUseCase{
    List<AuthorDto> findAll();

    Optional<AuthorDto> findById(Long idAuthor);

    AuthorDto save(AuthorDto authorDto);

    boolean delete(Long idAuthor);

    Optional<AuthorDto> update(AuthorDto authorDto);

    Optional<AuthorDto> findByName(String name);
}
