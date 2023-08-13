package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookCrudRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findByPriceBetween(double precioMin, double precioMax);

    List<BookEntity> findByIdTypeBookId(Long idTypeBook);
}

