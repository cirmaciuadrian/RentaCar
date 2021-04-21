package com.example.rentacar.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ChirieFinalizata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Float PretChirie;
    private Integer Daune;
    private Float PretTotal;
    private String Observatii;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Masina Masina;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Client Client;
}
