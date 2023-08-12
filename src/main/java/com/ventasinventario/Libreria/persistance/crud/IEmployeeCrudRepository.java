package com.ventasinventario.Libreria.persistance.crud;

import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEmployeeCrudRepository extends JpaRepository<EmployeeEntity,Long> {

    Optional<EmployeeEntity> findByEmail(String email);
}
