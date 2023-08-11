package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.TypeBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeBookCrudRepository extends JpaRepository<TypeBookEntity,Long> {
}
