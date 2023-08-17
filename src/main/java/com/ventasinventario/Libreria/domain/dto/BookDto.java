package com.ventasinventario.Libreria.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDto {

    private Long id;


    private String title;


    private AuthorDto idAuthor;


    private EmployeeDto idEmployee;


    private double price;


    private int numberOfPages;


    private int stock;

    private TypeBookDto idTypeBook;


    private PublishingDto idPublishing;


}
