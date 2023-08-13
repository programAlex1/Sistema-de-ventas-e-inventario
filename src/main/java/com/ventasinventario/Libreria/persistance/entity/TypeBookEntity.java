package com.ventasinventario.Libreria.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "tipo_libro")
public class TypeBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "idTypeBook",cascade = CascadeType.ALL)
    private List<BookEntity> bookEntities;
}
