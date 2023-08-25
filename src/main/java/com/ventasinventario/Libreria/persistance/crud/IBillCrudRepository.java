package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBillCrudRepository extends JpaRepository<SaleEntity,Long> {

    List<SaleEntity> findByIdCustomerCardId(Long cardId);
}
