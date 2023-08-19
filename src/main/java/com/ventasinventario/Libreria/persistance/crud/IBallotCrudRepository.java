package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.BallotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBallotCrudRepository extends JpaRepository<BallotEntity,Long> {
}
