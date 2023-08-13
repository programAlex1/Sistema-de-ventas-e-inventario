package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookUseCase {

    List<BookDto> findAll();

    Optional<BookDto> findById(Long idBook);

    BookDto save(BookDto bookDto);

    boolean delete(Long idBook);

    List<BookDto> findByPrecioBetween(double precioMin, double precioMax);

    Optional<BookDto> update(BookDto bookDto);

    List<BookDto> findByIdTypeBook(Long idTypeBook);
}
