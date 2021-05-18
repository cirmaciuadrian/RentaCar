package com.example.rentacar.services;

import com.example.rentacar.domain.ChirieActiva;

import java.util.List;

public interface ChirieActivaService {
    List<ChirieActiva> getAll();
    ChirieActiva save(ChirieActiva chirieActiva);
    ChirieActiva findById(Integer id);
    void delete(Integer id);
}
