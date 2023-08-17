package com.ventasinventario.Libreria.persistance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "autor")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String name;

    @OneToMany(mappedBy = "idAuthor",cascade = CascadeType.ALL)
    private List<BookEntity> bookList;
}
