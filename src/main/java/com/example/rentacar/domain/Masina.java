package com.example.rentacar.domain;

import lombok.Data;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message="Camp obligatoriu")
    @Size(min=1, max=30, message = "Camp obligatoriu")
    private String model;
    @NotNull(message="Camp obligatoriu")
    private Integer capacitateCilindrica;
    @NotNull(message="Camp obligatoriu")
    private Integer putere;
    @NotNull(message="Camp obligatoriu")
    @Min(value=2006, message ="Prea veche")
    private Integer anProductie;
    @NotNull(message="Camp obligatoriu")
    @Size(min=1, max=30, message = "Camp obligatoriu")
    private String culoare;
    @NotNull(message="Camp obligatoriu")
    @Size(min=1, max=30, message = "Camp obligatoriu")
    private String numarInmatriculare;
    @NotNull(message="Camp obligatoriu")
    @Min(value=50, message ="Prea ieftin!")
    private Float pret;
    private Boolean esteInchiriata;

    @OneToOne(mappedBy = "masina")
    private ChirieActiva ChirieActiva;

    @OneToMany(mappedBy = "masina")
    private List<ChirieFinalizata> ChiriiFinalizate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Firma firma;

    @ManyToMany(mappedBy = "masini",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Categorie> categoriiMasina;

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", putere=" + putere +
                ", anProductie=" + anProductie +
                ", culoare='" + culoare + '\'' +
                ", numarInmatriculare='" + numarInmatriculare + '\'' +
                ", pret=" + pret +
                ", esteInchiriata=" + esteInchiriata +
                '}';
    }
}
