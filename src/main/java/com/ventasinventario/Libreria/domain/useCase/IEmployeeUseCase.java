package com.ventasinventario.Libreria.domain.useCase;

import com.ventasinventario.Libreria.domain.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface IEmployeeUseCase {
    List<EmployeeDto> findAll();

    Optional<EmployeeDto> findById(Long idEmployee);

    EmployeeDto save(EmployeeDto employeeDto);

    Optional<EmployeeDto> update(EmployeeDto employeeDto);
    boolean delete(Long idEmployee);

    Optional<EmployeeDto> findByEmail(String email);
}
