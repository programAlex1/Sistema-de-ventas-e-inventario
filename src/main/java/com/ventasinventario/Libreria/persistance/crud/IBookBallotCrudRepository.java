package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.BookBallotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBallotCrudRepository extends JpaRepository<BookBallotEntity,Long> {
}
