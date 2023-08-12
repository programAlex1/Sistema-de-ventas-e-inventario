package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.PublishingDto;

import java.util.List;
import java.util.Optional;

public interface IPublishingUseCase {
    List<PublishingDto> findAll();

    Optional<PublishingDto> findById(Long idPublishing);

    PublishingDto save(PublishingDto publishingDto);

    Optional<PublishingDto> update(PublishingDto publishingDto);

    boolean delete(Long idBook);
}
