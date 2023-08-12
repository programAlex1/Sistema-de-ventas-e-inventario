package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
@Getter @Setter
public class EmployeeDto {
    private Long id;

    private String name;

    private String lastname;

    private String cellphonenumber;

    private String email;

    private Calendar dateofbirth;

    private String genre;

    private String dni;
}
