package com.example.rentacar.domain;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Model;
    private Integer CapacitateCilindrica;
    private Integer Putere;
    private Integer AnProductie;
    private String Culoare;
    private String NumarInmatriculare;

    private Float Pret;
    private Boolean EsteInchiriata;

    @OneToOne(mappedBy = "Masina")
    private ChirieActiva ChirieActiva;

    @OneToMany(mappedBy = "Masina")
    private List<ChirieFinalizata> ChiriiFinalizate;

    @OneToOne
    private Firma Firma;

    @ManyToMany(mappedBy = "Masini",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Categorie> CategoriiMasina;

}
