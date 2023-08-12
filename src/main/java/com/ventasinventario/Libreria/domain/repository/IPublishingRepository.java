package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.domain.dto.TypeBookDto;

import java.util.List;
import java.util.Optional;

public interface IPublishingRepository {
    List<PublishingDto> findAll();

    Optional<PublishingDto> findById(Long idPublishing);

    PublishingDto save(PublishingDto publishingDto);

    void delete(Long idBook);
}
