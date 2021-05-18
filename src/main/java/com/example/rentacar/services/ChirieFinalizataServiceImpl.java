package com.example.rentacar.services;

import com.example.rentacar.domain.ChirieFinalizata;
import com.example.rentacar.repos.ChirieFinalizataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChirieFinalizataServiceImpl  implements ChirieFinalizataService {
    ChirieFinalizataRepo chirieFinalizataRepo;

    @Autowired
    public ChirieFinalizataServiceImpl (ChirieFinalizataRepo chirieFinalizataRepo){
        this.chirieFinalizataRepo = chirieFinalizataRepo;
    }
    @Override
    public List<ChirieFinalizata> getAll(){
        return chirieFinalizataRepo.findAll();
    }
    @Override
    public ChirieFinalizata save(ChirieFinalizata chirieFinalizata)
    {
        return chirieFinalizataRepo.save(chirieFinalizata);
    }
}
