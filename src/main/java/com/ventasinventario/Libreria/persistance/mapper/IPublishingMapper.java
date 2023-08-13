package com.ventasinventario.Libreria.persistance.mapper;


import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.persistance.entity.PublishingEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPublishingMapper {
    /**
     * Convierte un entidad a dto de Editorial
     * @param publishingEntity Entidad a convertir
     * @return Dto convertido
     */
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    PublishingDto toPublishingDto(PublishingEntity publishingEntity);

    /**
     * Convierte un dto a entidad de Editorial
     * @param publishingDto Dto a convertir
     * @return Entidad convertida
     */
    @InheritInverseConfiguration
    @Mapping(target = "bookEntityList", ignore = true)
    PublishingEntity toPublishingEntity(PublishingDto publishingDto);

    /**
     * Convierte una lista de entidades a dto de Editorial
     * @param publishingEntityList Lista de entidades a convertir
     * @return Lista de dtos convertidas
     */
    List<PublishingDto> toPublishingsDto(List<PublishingEntity> publishingEntityList);
}
