package com.example.rentacar.domain;

import lombok.Data;


import java.util.Date;
import javax.persistence.*;

@Entity
@Data
public class ChirieActiva {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer IdMasina;
    private Integer IdClient;
    private Date  DataInchiriere;
    private Integer PerioadaInchiriere;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Client Client;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Masina Masina;


}
