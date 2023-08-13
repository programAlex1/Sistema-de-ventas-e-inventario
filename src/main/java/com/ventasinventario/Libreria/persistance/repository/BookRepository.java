package com.ventasinventario.Libreria.persistance.repository;


import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.persistance.crud.IBookCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.BookEntity;
import com.ventasinventario.Libreria.persistance.mapper.IBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookRepository implements IBookRepository {

    private final IBookMapper iBookMapper;
    private final IBookCrudRepository iBookCrudRepository;

    @Override
    public List<BookDto> findAll() {
        return iBookMapper.toBooksDto(iBookCrudRepository.findAll());
    }

    @Override
    public Optional<BookDto> findById(Long idBook) {
        return iBookCrudRepository.findById(idBook)
                .map(iBookMapper::toBookDto);
    }

    @Override
    public BookDto save(BookDto bookDto) {
        BookEntity bookEntity = iBookCrudRepository.save(iBookMapper.toBookEntity(bookDto));
        return iBookMapper.toBookDto(bookEntity);
    }

    @Override
    public void delete(Long idBook) {
        iBookCrudRepository.deleteById(idBook);
    }

    @Override
    public List<BookDto> findByPrecioBetween(double precioMin, double precioMax) {
        List<BookEntity> list=iBookCrudRepository.findByPriceBetween(precioMin,precioMax);
        return iBookMapper.toBooksDto(list);
    }

    @Override
    public List<BookDto> findByIdTypeBook(Long idTypeBook) {
        List<BookEntity> list = iBookCrudRepository.findByIdTypeBookId(idTypeBook);
        return iBookMapper.toBooksDto(list);
    }
}
