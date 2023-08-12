package com.ventasinventario.Libreria.persistance.mapper;


import com.ventasinventario.Libreria.domain.dto.EmployeeDto;
import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {

    @Mapping(target = "id",source = "id")
    EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity);

    EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toEmployeesDto(List<EmployeeEntity> employeeEntities);
}
