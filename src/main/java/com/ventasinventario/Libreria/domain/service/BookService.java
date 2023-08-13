package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.domain.repository.IPublishingRepository;
import com.ventasinventario.Libreria.domain.useCase.IBookUseCase;
import com.ventasinventario.Libreria.exception.PublishindNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BookService implements IBookUseCase {
    private final IBookRepository iBookRepository;

    private final IPublishingRepository iPublishingRepository;
    @Override
    public List<BookDto> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<BookDto> findById(Long idBook) {
        return iBookRepository.findById(idBook);
    }

    @Override
    public BookDto save(BookDto bookDto) {
        Long hola = bookDto.getIdPublishing().getId();
        if(iPublishingRepository.findById(hola).isEmpty()){
            throw new PublishindNotExistException();
        }

        return iBookRepository.save(bookDto);
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
