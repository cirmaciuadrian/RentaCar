package com.example.rentacar.services;

import com.example.rentacar.domain.Angajat;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.repos.AngajatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AngajatiServiceImpl implements AngajatiService {

    AngajatRepo angajatRepo;

    @Autowired
    public AngajatiServiceImpl(AngajatRepo angajatRepo) {
        this.angajatRepo = angajatRepo;
    }

    @Override
    public Page<Angajat> findAll(int page, int size, String sortBy, String sortType){
        Sort sort = sortType.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        return  angajatRepo.findAll(pageable);
    }

    @Override
    public Angajat save(Angajat angajat) {
        Angajat savedAngajat = angajatRepo.save(angajat);
        return savedAngajat;
    }

    @Override
    public void deleteById(int id) {
        Optional<Angajat> angajatOptional = angajatRepo.findById(id);
        if (!angajatOptional.isPresent()) {
            throw new ResourceNotFoundException("Angajatul nu a fost gasit!");
        }
        angajatRepo.deleteById(id);
    }

    @Override
    public boolean existaCnp(String Cnp){
        Optional<Angajat> angajatOptional = angajatRepo.findByCnp(Cnp);
        if (angajatOptional.isPresent())
            return true;
        else return false;
    }



}
