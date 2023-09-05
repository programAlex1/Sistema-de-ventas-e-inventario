package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.repository.*;
import com.ventasinventario.Libreria.domain.useCase.IBookUseCase;
import com.ventasinventario.Libreria.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BookService implements IBookUseCase {
    private final IBookRepository iBookRepository;

    private final IPublishingRepository iPublishingRepository;
    private final IAuthorRepository iAuthorRepository;
    private final ITypeBookRepository iTypeBookRepository;
    private final IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Optional<BookDto> findById(Long idBook) {
        return iBookRepository.findById(idBook);
    }

    @Override
    public BookDto save(BookDto bookDto) {
        if(iPublishingRepository.findById(bookDto.getIdPublishing().getId()).isEmpty())
            throw new ResourceNotFoundException("Publishing not found with ID " + bookDto.getIdPublishing().getId());

        if(iAuthorRepository.findById(bookDto.getIdAuthor().getId()).isEmpty())
            throw new ResourceNotFoundException("Author not found with ID " + bookDto.getIdAuthor().getId());

        if(iTypeBookRepository.findById(bookDto.getIdTypeBook().getId()).isEmpty())
            throw new ResourceNotFoundException("Type of book not found with ID " + bookDto.getIdTypeBook().getId());

        if(iEmployeeRepository.findById(bookDto.getIdEmployee().getId()).isEmpty())
            throw new ResourceNotFoundException("Employee not found with ID " + bookDto.getIdEmployee().getId());

        if(iBookRepository.findByTitle(bookDto.getTitle()).isEmpty()){
            return iBookRepository.save(bookDto);
        }

        throw new IllegalArgumentException("The Book already exists in the database ");
    }

    @Override
    public boolean delete(Long idBook) {
        if(iBookRepository.findById(idBook).isEmpty()){
            return false;
        }
        iBookRepository.delete(idBook);
        return true;
    }

    @Override
    public List<BookDto> findByPrecioBetween(double precioMin, double precioMax) {
        return iBookRepository.findByPrecioBetween(precioMin,precioMax);
    }

    @Override
    public Optional<BookDto> update(BookDto bookDto) {
        if (iBookRepository.findById(bookDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iBookRepository.save(bookDto));
    }

    @Override
    public List<BookDto> findByIdTypeBook(Long idTypeBook) {
        return iBookRepository.findByIdTypeBook(idTypeBook);
    }
}
