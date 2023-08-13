package com.ventasinventario.Libreria.persistance.mapper;

import com.ventasinventario.Libreria.domain.dto.TypeBookDto;
import com.ventasinventario.Libreria.persistance.entity.TypeBookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITypeBookMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    TypeBookDto toTypeBookDto(TypeBookEntity typeBookEntity);

    @InheritInverseConfiguration
    @Mapping(target = "bookEntities",ignore = true)
    TypeBookEntity toTypeBookEntity(TypeBookDto typeBookDto);
    List<TypeBookDto> toTypeBooksDto(List<TypeBookEntity> typeBookEntities);
}
