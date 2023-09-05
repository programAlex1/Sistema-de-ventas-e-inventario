package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    Page<BookDto> findAll(Pageable pageable);

    Optional<BookDto> findById(Long idBook);

    BookDto save(BookDto bookDto);

    void delete(Long idBook);

    List<BookDto> findByPrecioBetween(double precioMin, double precioMax);

    List<BookDto> findByIdTypeBook(Long idTypeBook);

    void updateStockLess(Long id, int quantity);

    void updateStockMore(Long id, int quantity);

    Optional<BookDto> findByTitle(String title);
}
