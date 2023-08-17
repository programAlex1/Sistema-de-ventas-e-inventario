package com.ventasinventario.Libreria.persistance.mapper;


import com.ventasinventario.Libreria.domain.dto.AuthorDto;
import com.ventasinventario.Libreria.persistance.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {

    AuthorDto toAuthorDto(AuthorEntity author);

    @Mapping(target = "bookList",ignore = true)
    AuthorEntity toAuthorEntity(AuthorDto authorDto);

    List<AuthorDto> toAuthorsDto(List<AuthorEntity> authorEntityList);


}
