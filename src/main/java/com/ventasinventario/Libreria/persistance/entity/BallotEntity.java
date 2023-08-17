package com.ventasinventario.Libreria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "boleta")
public class BallotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha",nullable = false)
    private Date date;
    @ManyToOne()
    @JoinColumn(name = "id_empleado",nullable = false)
    private EmployeeEntity idEmployee;
    @ManyToOne()
    @JoinColumn(name = "id_cliente",nullable = false)
    private CustomerEntity idCustomer;
    @Column(name = "total",nullable = false)
    private double total;
    @Column(name = "metodo_pago",nullable = false)
    private String method;
    @OneToMany(mappedBy = "ballot",cascade = CascadeType.ALL)
    private List<BookBallotEntity> bookList;

}
