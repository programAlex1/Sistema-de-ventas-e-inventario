package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookCrudRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findByPriceBetween(double precioMin, double precioMax);

    List<BookEntity> findByIdTypeBookId(Long idTypeBook);

    @Modifying
    @Transactional
    @Query("UPDATE BookEntity b SET b.stock = b.stock - :quantity WHERE b.id = :id")
    void updateStock(Long id,int quantity);
}

