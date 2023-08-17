package com.ventasinventario.Libreria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity
@Getter @Setter
@Table(name = "empleado")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String name;

    @Column(name = "apellido",nullable = false)
    private String lastname;

    @Column(name = "numero_celular",nullable = false)
    private String cellphonenumber;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "fecha_nacimiento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;

    @Column(name = "genero",nullable = false)
    private String genre;

    @Column(name = "dni",nullable = false)
    private String dni;

    @OneToMany(mappedBy = "idEmployee",cascade = CascadeType.ALL)
    private List<BookEntity> bookEntities;


}
