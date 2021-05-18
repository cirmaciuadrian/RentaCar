package com.example.rentacar.domain;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=3, max=30, message = "Minim 3 caractere, maxim 30!")
    @NotNull(message = "Campul nume nu poate fi gol!")
    private String nume;
    @Size(min=3, max=30, message = "Minim 3 caractere, maxim 30!")
    @NotNull(message = "Campul nume nu poate fi gol!")
    private String prenume;
    @Pattern(regexp="^[0-9]*$", message = "Cnp invalid!")
    @Size(min=13, max=13, message = "Cnp are 13 caractere!")
    private String cnp;
    @Email
    @NotNull
    private String email;
    @Pattern(regexp="^[0-9]*$", message = "Telefon invalid!")
    @Size(min=10, max=10, message = "Telefonul are 10 caractere!")
    private String telefon;

    @OneToMany(mappedBy = "client",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<ChirieFinalizata> ciriiFinalizate;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private ChirieActiva chirieActiva;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp='" + cnp + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
