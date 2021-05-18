package com.example.rentacar.domain;

import lombok.Data;


import java.util.Date;
import javax.persistence.*;

@Entity
@Data
public class ChirieActiva {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date  dataInchiriere;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(cascade = {CascadeType.ALL})
    private Masina masina;

    @Override
    public String toString() {
        return "ChirieActiva{" +
                "id=" + id +
                ", dataInchiriere=" + dataInchiriere +
                ", client=" + client +
                ", masina=" + masina +
                '}';
    }
}
