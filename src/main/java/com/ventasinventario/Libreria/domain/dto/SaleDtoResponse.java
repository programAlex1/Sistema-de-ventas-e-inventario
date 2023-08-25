package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter@Setter
public class SaleDtoResponse {

    private Long id;

    private Date date;

    private Long idEmployee; // Le paso

    private Long idCustomer; // Le paso

    private double total;

    private String method; // Le paso

    private List<BookSaleResponseDto> bookList; // Le paso

}
