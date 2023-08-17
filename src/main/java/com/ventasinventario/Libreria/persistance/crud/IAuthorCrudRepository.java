package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthorCrudRepository extends JpaRepository<AuthorEntity,Long> {

    Optional<AuthorEntity> findByName(String name);
}
