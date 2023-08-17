package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.AuthorDto;
import com.ventasinventario.Libreria.domain.repository.IAuthorRepository;
import com.ventasinventario.Libreria.persistance.crud.IAuthorCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.AuthorEntity;
import com.ventasinventario.Libreria.persistance.mapper.IAuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AuthorRepository implements IAuthorRepository {

    private final IAuthorMapper iAuthorMapper;

    private final IAuthorCrudRepository iAuthorCrudRepository;
    @Override
    public List<AuthorDto> findAll() {
        return iAuthorMapper.toAuthorsDto(iAuthorCrudRepository.findAll());
    }

    @Override
    public Optional<AuthorDto> findById(Long idAuthor) {
        return iAuthorCrudRepository.findById(idAuthor)
                .map(iAuthorMapper::toAuthorDto);
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        AuthorEntity author= iAuthorCrudRepository.save(iAuthorMapper.toAuthorEntity(authorDto));
        return iAuthorMapper.toAuthorDto(author);
    }

    @Override
    public void delete(Long idAuthor) {
        iAuthorCrudRepository.deleteById(idAuthor);
    }

    @Override
    public Optional<AuthorDto> findByName(String name) {
        return iAuthorCrudRepository.findByName(name)
                .map(iAuthorMapper::toAuthorDto);
    }
}
