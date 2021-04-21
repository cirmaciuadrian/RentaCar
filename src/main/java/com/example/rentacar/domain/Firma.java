package com.example.rentacar.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String NumeFirma;

    @OneToOne(mappedBy = "Firma")
    private Masina Masina;
}
