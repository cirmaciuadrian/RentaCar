package com.example.rentacar.services;

import com.example.rentacar.domain.ChirieFinalizata;

import java.util.List;

public interface ChirieFinalizataService {
    List<ChirieFinalizata> getAll();
    ChirieFinalizata save(ChirieFinalizata chirieFinalizata);
}
