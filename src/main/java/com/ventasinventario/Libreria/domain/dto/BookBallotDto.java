package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookBallotDto {

    private Long id;

    private Long idBook;

    private String nameBook;

    private Long idBallot;

    private double price;

    private int quantity;

    private double total;
}
