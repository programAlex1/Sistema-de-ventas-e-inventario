package com.ventasinventario.Libreria.domain.service;

import com.ventasinventario.Libreria.domain.dto.EmployeeDto;
import com.ventasinventario.Libreria.domain.repository.IEmployeeRepository;
import com.ventasinventario.Libreria.domain.useCase.IEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService implements IEmployeeUseCase {
    private final IEmployeeRepository iEmployeeRepository;
    @Override
    public List<EmployeeDto> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeDto> findById(Long idEmployee) {
        return iEmployeeRepository.findById(idEmployee);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return iEmployeeRepository.save(employeeDto);
    }

    @Override
    public Optional<EmployeeDto> update(EmployeeDto employeeDto) {
        if (iEmployeeRepository.findById(employeeDto.getId()).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(iEmployeeRepository.save(employeeDto));
    }

    @Override
    public boolean delete(Long idEmployee) {
       if(iEmployeeRepository.findById(idEmployee).isEmpty()){
           return false;

       }
       iEmployeeRepository.delete(idEmployee);
       return true;
    }

    @Override
    public Optional<EmployeeDto> findByEmail(String email) {
        return iEmployeeRepository.findByEmail(email);
    }
}
