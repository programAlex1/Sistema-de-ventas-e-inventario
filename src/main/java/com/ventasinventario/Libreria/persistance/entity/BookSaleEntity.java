package com.ventasinventario.Libreria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "libroxboleta")
public class BookSaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_libro")
    private BookEntity book;
    @ManyToOne()
    @JoinColumn(name = "id_boleta")
    private SaleEntity ballot;
    @Column(name = "cantidad")
    private int quantity;
    @Column(name = "precio")
    private double price;
    @Column(name = "total")
    private double total;
}
