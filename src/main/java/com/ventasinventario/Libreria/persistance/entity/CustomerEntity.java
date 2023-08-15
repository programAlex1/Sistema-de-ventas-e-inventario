package com.ventasinventario.Libreria.persistance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {
    @Id
    @Column(name = "id")
    private Long cardId;
    @Column(name = "nombre_completo",nullable = false)
    private String fullName;
    @Column(name = "telefono",nullable = false)
    private String cellphone;
    @Column(name = "direccion",nullable = false)
    private String address;
    @Column(name = "fecha_nacimiento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

}
