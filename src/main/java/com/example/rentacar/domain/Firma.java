package com.example.rentacar.domain;



import javax.persistence.*;
import java.util.List;

@Entity

public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeFirma;

    @OneToMany(mappedBy = "firma")
    private List<Masina> masinini;

    public Firma(Integer id, String numeFirma, List<Masina> masinini) {
        this.id = id;
        this.numeFirma = numeFirma;
        this.masinini = masinini;
    }

    public Firma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeFirma() {
        return numeFirma;
    }

    public void setNumeFirma(String numeFirma) {
        this.numeFirma = numeFirma;
    }

    public List<Masina> getMasinini() {
        return masinini;
    }

    public void setMasinini(List<Masina> masinini) {
        this.masinini = masinini;
    }

    @Override
    public String toString() {
        return "Firma{" +
                "id=" + id +
                ", numeFirma='" + numeFirma + '\'' +
                '}';
    }
}
