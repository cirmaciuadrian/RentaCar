package com.example.rentacar.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Nume;
    private String Prenume;
    private String Cnp;
    private String Email;
    private String Telefon;

    @OneToMany(mappedBy = "Client",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ChirieFinalizata> CiriiFinalizate;

    @OneToOne(mappedBy = "Client")
    private ChirieActiva ChirieActiva;

}
