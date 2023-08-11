package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.TypeBookDto;
import com.ventasinventario.Libreria.domain.repository.ITypeBookRepository;
import com.ventasinventario.Libreria.domain.useCase.ITypeBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TypeBookService implements ITypeBookUseCase {

    private final ITypeBookRepository iTypeBookRepository;
    @Override
    public List<TypeBookDto> findAll() {
        return iTypeBookRepository.findAll();
    }

    @Override
    public Optional<TypeBookDto> findById(Long idBook) {
        return iTypeBookRepository.findById(idBook);
    }

    @Override
    public TypeBookDto save(TypeBookDto typeBookDto) {
        return iTypeBookRepository.save(typeBookDto);
    }

    @Override
    public Optional<TypeBookDto> update(TypeBookDto typeBookDto) {
        if(iTypeBookRepository.findById(typeBookDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iTypeBookRepository.save(typeBookDto));
    }

    @Override
    public boolean delete(Long idBook) {

        if(iTypeBookRepository.findById(idBook).isEmpty()){
            return false;
        }
        iTypeBookRepository.delete(idBook);
        return true;

    }
}