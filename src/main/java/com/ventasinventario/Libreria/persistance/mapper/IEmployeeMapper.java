package com.ventasinventario.Libreria.persistance.mapper;


import com.ventasinventario.Libreria.domain.dto.EmployeeDto;
import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "lastname",target = "lastname")
    @Mapping(source = "cellphonenumber",target = "cellphonenumber")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "dateofbirth",target = "dateofbirth")
    @Mapping(source = "genre",target = "genre")
    @Mapping(source = "dni",target = "dni")
    EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity);

    @InheritInverseConfiguration
    @Mapping(target = "bookEntities", ignore = true)
    EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toEmployeesDto(List<EmployeeEntity> employeeEntities);
}
