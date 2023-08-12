package com.ventasinventario.Libreria.persistance.mapper;


import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.persistance.entity.PublishingEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPublishingMapper {
    /**
     * Convierte un entidad a dto de Editorial
     * @param publishingEntity Entidad a convertir
     * @return Dto convertido
     */
    PublishingDto toPublishingDto(PublishingEntity publishingEntity);

    /**
     * Convierte un dto a entidad de Editorial
     * @param publishingDto Dto a convertir
     * @return Entidad convertida
     */

    PublishingEntity toPublishingEntity(PublishingDto publishingDto);

    /**
     * Convierte una lista de entidades a dto de Editorial
     * @param publishingEntityList Lista de entidades a convertir
     * @return Lista de dtos convertidas
     */
    List<PublishingDto> toPublishingsDto(List<PublishingEntity> publishingEntityList);
}
