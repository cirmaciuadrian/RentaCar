package com.example.rentacar.services;

import com.example.rentacar.domain.ChirieActiva;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.repos.ChirieActivaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChirieActivaServiceImpl implements ChirieActivaService {
    ChirieActivaRepo chirieActivaRepo;

    @Autowired
    public ChirieActivaServiceImpl (ChirieActivaRepo chirieActivaRepo){
        this.chirieActivaRepo=chirieActivaRepo;
    }
    @Override
    public List<ChirieActiva> getAll(){
        return chirieActivaRepo.findAll();
    }
    @Override
    public ChirieActiva save(ChirieActiva chirieActiva){

        return chirieActivaRepo.save(chirieActiva);
    }
    @Override
    public ChirieActiva findById(Integer id){
        var chirieActivaOptional = chirieActivaRepo.findById(id);
        if(!chirieActivaOptional.isPresent())
           throw new ResourceNotFoundException("Nu gasesc chiria activa");
        return chirieActivaOptional.get();
    }
    @Override
    public void delete(Integer id){
        var chirieCurenta = findById(id);
        chirieActivaRepo.delete(chirieCurenta);
    }
}
