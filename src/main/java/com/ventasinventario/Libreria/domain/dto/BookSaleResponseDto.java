package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSaleResponseDto {

    private Long id;

    private Long idBook;

    private String nameBook;

    private Long idSale;

    private double price;

    private int quantity;

    private double total;
}
