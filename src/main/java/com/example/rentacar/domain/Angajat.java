package com.example.rentacar.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=3, max=30, message = "Minim 3 caractere, maxim 30!")
    @NotNull(message = "Campul nume nu poate fi gol!")
    private String nume;
    @Size(min=3, max=30, message = "Minim 3 caractere, maxim 30!")
    @NotNull(message = "Campul prenume nu poate fi gol!")
    private String prenume;
    @Min(value=18, message ="Trebuie sa fie major")
    @Max(value=70, message ="Prea batran pentru a muncii!")
    private Integer varsta;
    @Pattern(regexp="^[0-9]*$", message = "Cnp invalid!")
    @Size(min=13, max=13, message = "Cnp are 13 caractere!")
    private String cnp;
}
