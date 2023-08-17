package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.AuthorDto;
import com.ventasinventario.Libreria.domain.repository.IAuthorRepository;
import com.ventasinventario.Libreria.domain.useCase.IAuthorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorUseCase {

    private final IAuthorRepository iAuthorRepository;
    @Override
    public List<AuthorDto> findAll() {
        return iAuthorRepository.findAll();
    }

    @Override
    public Optional<AuthorDto> findById(Long idAuthor) {
        return iAuthorRepository.findById(idAuthor);
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        return iAuthorRepository.save(authorDto);
    }

    @Override
    public boolean delete(Long idAuthor) {
        if(iAuthorRepository.findById(idAuthor).isEmpty()){
            return false;
        }
        iAuthorRepository.delete(idAuthor);
        return true;
    }

    @Override
    public Optional<AuthorDto> update(AuthorDto authorDto) {
       if(iAuthorRepository.findById(authorDto.getId()).isEmpty()){
           return Optional.empty();
       }
       return Optional.of(iAuthorRepository.save(authorDto));
    }

    @Override
    public Optional<AuthorDto> findByName(String name) {
        return iAuthorRepository.findByName(name);
    }
}
