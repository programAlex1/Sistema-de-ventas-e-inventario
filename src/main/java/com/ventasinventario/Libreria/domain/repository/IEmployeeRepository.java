package com.ventasinventario.Libreria.domain.repository;

import com.ventasinventario.Libreria.domain.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {

    List<EmployeeDto> findAll();

    Optional<EmployeeDto> findById(Long idEmployee);

    EmployeeDto save(EmployeeDto employeeDto);

    void delete(Long idEmployee);

    Optional<EmployeeDto> findByEmail(String email);
}
