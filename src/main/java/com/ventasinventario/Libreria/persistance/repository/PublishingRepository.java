package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.PublishingDto;
import com.ventasinventario.Libreria.domain.repository.IPublishingRepository;
import com.ventasinventario.Libreria.persistance.crud.IPublishingCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.PublishingEntity;
import com.ventasinventario.Libreria.persistance.mapper.IPublishingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class PublishingRepository implements IPublishingRepository {
    private final IPublishingMapper iPublishingMapper;
    private final IPublishingCrudRepository iPublishingCrudRepository;

    @Override
    public List<PublishingDto> findAll() {

        return iPublishingMapper.toPublishingsDto(iPublishingCrudRepository.findAll());
    }

    @Override
    public Optional<PublishingDto> findById(Long idPublishing) {

        return iPublishingCrudRepository.findById(idPublishing)
                .map(iPublishingMapper::toPublishingDto);
    }

    @Override
    public PublishingDto save(PublishingDto publishingDto)    {
        PublishingEntity publishingEntity = iPublishingCrudRepository.save(iPublishingMapper.toPublishingEntity(publishingDto));
        return iPublishingMapper.toPublishingDto(publishingEntity);
    }

    @Override
    public void delete(Long idBook) {
        iPublishingCrudRepository.deleteById(idBook);
    }
}
