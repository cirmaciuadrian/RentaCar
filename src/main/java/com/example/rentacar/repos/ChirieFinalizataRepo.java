package com.example.rentacar.repos;


import com.example.rentacar.domain.ChirieFinalizata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChirieFinalizataRepo extends JpaRepository<ChirieFinalizata, Integer> {
}
