package com.example.rentacar.services;

import com.example.rentacar.domain.Angajat;
import com.example.rentacar.repos.AngajatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AngajatiServiceImpl implements AngajatiService {

    AngajatRepo angajatRepo;

    @Autowired
    public AngajatiServiceImpl(AngajatRepo angajatRepo) {
        this.angajatRepo = angajatRepo;
    }

    @Override
    public List<Angajat> findAll(){
        List<Angajat> angajati =  angajatRepo.findAll();
        return angajati;
    }
}
