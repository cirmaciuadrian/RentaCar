package com.example.rentacar.services;

import com.example.rentacar.domain.Categorie;
import com.example.rentacar.repos.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    CategorieRepo categorieRepo;

    @Autowired
    public CategorieServiceImpl (CategorieRepo categorieRepo){
        this.categorieRepo = categorieRepo;
    }

    public List<Categorie> findAll(){
       return categorieRepo.findAll();
    }
}
