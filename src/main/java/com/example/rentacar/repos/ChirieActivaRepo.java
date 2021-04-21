package com.example.rentacar.repos;

import com.example.rentacar.domain.ChirieActiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChirieActivaRepo extends JpaRepository<ChirieActiva, Integer> {
}
