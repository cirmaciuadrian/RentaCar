package com.example.rentacar.services;

import com.example.rentacar.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Client findById(Integer Id);
    Client findByCnp(String Cnp);
    boolean existaCnp(String Cnp);
    void save(Client client);
    boolean existaEmail(String email);
}
