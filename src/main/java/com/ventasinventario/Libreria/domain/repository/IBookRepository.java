package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    List<BookDto> findAll();

    Optional<BookDto> findById(Long idBook);

    BookDto save(BookDto bookDto);

    void delete(Long idBook);

    List<BookDto> findByPrecioBetween(double precioMin, double precioMax);

    List<BookDto> findByIdTypeBook(Long idTypeBook);
}
