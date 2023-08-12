package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublishingCrudRepository extends JpaRepository<PublishingEntity,Long> {
}
