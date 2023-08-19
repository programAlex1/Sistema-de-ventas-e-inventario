package com.ventasinventario.Libreria.domain.dto;

import com.ventasinventario.Libreria.persistance.entity.CustomerEntity;
import com.ventasinventario.Libreria.persistance.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BallotDto {

    private Long id;

    private Date date;

    private Long idEmployee; // Le paso

    private Long idCustomer; // Le paso

    private double total;

    private String method; // Le paso

    private List<BookBallotDto> bookList; // Le paso

}
