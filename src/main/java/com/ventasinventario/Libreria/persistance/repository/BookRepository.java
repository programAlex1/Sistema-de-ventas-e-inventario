package com.ventasinventario.Libreria.persistance.repository;


import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.domain.repository.IBookRepository;
import com.ventasinventario.Libreria.persistance.crud.*;
import com.ventasinventario.Libreria.persistance.entity.*;
import com.ventasinventario.Libreria.persistance.mapper.IBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookRepository implements IBookRepository {

    private final IBookMapper iBookMapper;
    private final IBookCrudRepository iBookCrudRepository;
    private final IEmployeeCrudRepository iEmployeeCrudRepository;
    private final IPublishingCrudRepository iPublishingCrudRepository;
    private final ITypeBookCrudRepository iTypeBookCrudRepository;
    private final IAuthorCrudRepository iAuthorCrudRepository;
    @Override
    public List<BookDto> findAll(Sort sort) {
        return iBookMapper.toBooksDto(iBookCrudRepository.findAll(sort));
    }

    @Override
    public Optional<BookDto> findById(Long idBook) {
        return iBookCrudRepository.findById(idBook)
                .map(iBookMapper::toBookDto);
    }

    @Override
    public BookDto save(BookDto bookDto) {
        BookEntity bookEntity = iBookCrudRepository.save(iBookMapper.toBookEntity(bookDto));
        BookDto dto = iBookMapper.toBookDto(bookEntity);
        EmployeeSet(dto,dto.getIdEmployee().getId());
        AuthorSet(dto,dto.getIdAuthor().getId());
        TypeBookSet(dto,dto.getIdTypeBook().getId());
        PublishingSet(dto,dto.getIdPublishing().getId());
        return dto;
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

    @Override
    public void updateStock(Long id, int quantity) {
        iBookCrudRepository.updateStock(id,quantity);
    }

    @Override
    public Optional<BookDto> findByTitle(String title) {
        return iBookCrudRepository.findByTitle(title)
                .map(iBookMapper::toBookDto);
    }

    public BookDto EmployeeSet(BookDto dto,Long id){
        Optional<EmployeeEntity> entity = iEmployeeCrudRepository.findById(id);
        dto.getIdEmployee().setCellphonenumber(entity.get().getCellphonenumber());
        dto.getIdEmployee().setDni(entity.get().getDni());
        dto.getIdEmployee().setGenre(entity.get().getGenre());
        dto.getIdEmployee().setEmail(entity.get().getEmail());
        dto.getIdEmployee().setDateofbirth(entity.get().getDateofbirth());
        dto.getIdEmployee().setName(entity.get().getName());
        dto.getIdEmployee().setLastname(entity.get().getLastname());
        return dto;
    }
    public BookDto AuthorSet(BookDto dto,Long id){
        Optional<AuthorEntity> entity = iAuthorCrudRepository.findById(id);
        dto.getIdAuthor().setName(entity.get().getName());
        return dto;
    }
    public BookDto TypeBookSet(BookDto dto,Long id){
        Optional<TypeBookEntity> entity = iTypeBookCrudRepository.findById(id);
        dto.getIdTypeBook().setName(entity.get().getName());
        return dto;
    }

    public BookDto PublishingSet(BookDto dto,Long id){
        Optional<PublishingEntity> entity = iPublishingCrudRepository.findById(id);
        dto.getIdPublishing().setName(entity.get().getName());
        return dto;
    }
}
