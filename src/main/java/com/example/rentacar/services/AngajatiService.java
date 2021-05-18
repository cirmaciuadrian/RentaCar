package com.example.rentacar.services;

import com.example.rentacar.domain.Angajat;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AngajatiService {
    Page<Angajat> findAll(int page, int size, String sortBy, String sortType);
    Angajat save(Angajat angajat);
    void deleteById(int id);
    boolean existaCnp(String Cnp);

}
