package com.example.rentacar.services;

import com.example.rentacar.domain.Firma;
import com.example.rentacar.repos.FirmaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaServiceImpl implements  FirmaService {
    FirmaRepo firmaRepo;

    @Autowired
    public FirmaServiceImpl (FirmaRepo firmaRepo){
        this.firmaRepo = firmaRepo;
    }

    @Override
    public List<Firma> getAll(){
        return firmaRepo.findAll();
    }
}
