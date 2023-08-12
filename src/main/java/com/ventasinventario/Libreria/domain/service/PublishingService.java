package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.domain.repository.IPublishingRepository;
import com.ventasinventario.Libreria.domain.useCase.IPublishingUseCase;
import com.ventasinventario.Libreria.exception.PublishingNameEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class PublishingService implements IPublishingUseCase {

    private final IPublishingRepository iPublishingRepository;
    @Override
    public List<PublishingDto> findAll() {
        return iPublishingRepository.findAll();
    }

    @Override
    public Optional<PublishingDto> findById(Long idPublishing) {
        return iPublishingRepository.findById(idPublishing);
    }

    @Override
    public PublishingDto save(PublishingDto publishingDto) {
        if(publishingDto.getName().isEmpty()){
            throw new PublishingNameEmptyException();
        }
        return iPublishingRepository.save(publishingDto);
    }

    @Override
    public Optional<PublishingDto> update(PublishingDto publishingDto) {
        if (iPublishingRepository.findById(publishingDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iPublishingRepository.save(publishingDto));
    }

    @Override
    public boolean delete(Long idBook) {
        if (iPublishingRepository.findById(idBook).isEmpty()){
            return false;
        }

        iPublishingRepository.delete(idBook);
        return true;
    }
}
