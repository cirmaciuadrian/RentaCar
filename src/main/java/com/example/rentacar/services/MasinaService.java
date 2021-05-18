package com.example.rentacar.services;

import com.example.rentacar.domain.Masina;

import java.util.List;

public interface MasinaService {
    List<Masina> findMasini(Integer categorieSelectata, String status);
    Masina findById(Integer id);
    List<Masina> findAllByCategorie(Integer id);
    Boolean existaNrInamtriculare(String nrInmatriculare);
    Masina saveOrUpdate(Masina masina);

}
