package com.example.rentacar.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ChirieFinalizata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float pretTotal;
    private Date dataInceput;
    private Date dataSfarsit;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Masina masina;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Client client;

    @Override
    public String toString() {
        return "ChirieFinalizata{" +
                "id=" + id +
                ", pretTotal=" + pretTotal +
                ", dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                '}';
    }
}
