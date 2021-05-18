package com.example.rentacar.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categorie;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "categorie_masina",
            joinColumns =@JoinColumn(name="categorie_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="masina_id",referencedColumnName="id"))
    private List<Masina> masini;
}
