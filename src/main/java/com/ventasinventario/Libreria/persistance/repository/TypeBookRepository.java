package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.TypeBookDto;
import com.ventasinventario.Libreria.domain.repository.ITypeBookRepository;
import com.ventasinventario.Libreria.persistance.crud.ITypeBookCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.TypeBookEntity;
import com.ventasinventario.Libreria.persistance.mapper.ITypeBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class TypeBookRepository implements ITypeBookRepository {

    private final ITypeBookCrudRepository iTypeBookCrudRepository;

    private final ITypeBookMapper iTypeBookMapper;
    @Override
    public List<TypeBookDto> findAll() {
        return iTypeBookMapper
                .toTypeBooksDto(iTypeBookCrudRepository.findAll());
    }
    @Override
    public Optional<TypeBookDto> findById(Long idBook) {
        return iTypeBookCrudRepository.findById(idBook)
                .map(iTypeBookMapper::toTypeBookDto);
    }

    @Override
    public TypeBookDto save(TypeBookDto typeBookDto) {
        TypeBookEntity typeBookEntity =iTypeBookCrudRepository.save(iTypeBookMapper.toTypeBookEntity(typeBookDto));
        return iTypeBookMapper.toTypeBookDto(typeBookEntity);
    }

    @Override
    public void delete(Long idBook) {
        iTypeBookCrudRepository.deleteById(idBook);
    }
}
