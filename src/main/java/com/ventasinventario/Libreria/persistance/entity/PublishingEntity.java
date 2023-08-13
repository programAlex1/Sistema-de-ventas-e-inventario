package com.ventasinventario.Libreria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Entity
@Table(name = "editorial")
public class PublishingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "idPublishing",cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;
}
