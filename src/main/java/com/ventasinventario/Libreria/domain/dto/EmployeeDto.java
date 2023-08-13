package com.ventasinventario.Libreria.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter @Setter
public class EmployeeDto {
    private Long id;

    private String name;

    private String lastname;

    private String cellphonenumber;

    private String email;

    private Date dateofbirth;

    private String genre;

    private String dni;
}
