package com.ventasinventario.Libreria.persistance.mapper;

import com.ventasinventario.Libreria.domain.dto.BookDto;
import com.ventasinventario.Libreria.persistance.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookMapper {


    BookDto toBookDto(BookEntity bookEntity);

    @Mapping(target = "bookList",ignore = true)
    BookEntity toBookEntity(BookDto bookDto);

    List<BookDto> toBooksDto(List<BookEntity> listBookEntity);

}
