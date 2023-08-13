package com.ventasinventario.Libreria.persistance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "libro")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo",nullable = false)
    private String title;

    @Column(name = "autor",nullable = false)
    private String author;

    @Column(name = "id_employee",nullable = false)
    private Long idEmployee;

    @Column(name = "precio",nullable = false)
    private double price;

    @Column(name = "numero_paginas",nullable = false)
    private int numberOfPages;

    @Column(name = "stock",nullable = false)
    private int stock;

    @ManyToOne()
    @JoinColumn(name = "id_tipolibro")
    private TypeBookEntity idTypeBook;

    @ManyToOne()
    @JoinColumn(name = "id_editorial")
    private PublishingEntity idPublishing;

    @ManyToOne()
    @JoinColumn(name = "id_employee", updatable = false,insertable = false)
    private EmployeeEntity employeeEntity;


}
