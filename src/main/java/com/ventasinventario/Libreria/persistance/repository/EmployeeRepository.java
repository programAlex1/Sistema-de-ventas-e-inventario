package com.ventasinventario.Libreria.persistance.repository;

import com.ventasinventario.Libreria.domain.dto.EmployeeDto;
import com.ventasinventario.Libreria.domain.repository.IEmployeeRepository;
import com.ventasinventario.Libreria.persistance.crud.IEmployeeCrudRepository;
import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import com.ventasinventario.Libreria.persistance.mapper.IEmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private final IEmployeeMapper iEmployeeMapper;

    private final IEmployeeCrudRepository iEmployeeCrudRepository;
    @Override
    public List<EmployeeDto> findAll() {
        return iEmployeeMapper.toEmployeesDto(iEmployeeCrudRepository.findAll());
    }

    @Override
    public Optional<EmployeeDto> findById(Long idEmployee) {

        return iEmployeeCrudRepository.findById(idEmployee)
                .map(iEmployeeMapper::toEmployeeDto);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity =iEmployeeCrudRepository.save(iEmployeeMapper.toEmployeeEntity(employeeDto));
        return iEmployeeMapper.toEmployeeDto(employeeEntity);
    }

    @Override
    public void delete(Long idEmployee) {
        iEmployeeCrudRepository.deleteById(idEmployee);
    }

    @Override
    public Optional<EmployeeDto> findByEmail(String email) {

        return iEmployeeCrudRepository.findByEmail(email)
                .map(iEmployeeMapper::toEmployeeDto);
    }
}
