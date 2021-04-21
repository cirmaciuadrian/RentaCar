package com.example.rentacar.domain;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nume;
    private String Prenume;
    private Integer Varsta;
    private String Cnp;
}
