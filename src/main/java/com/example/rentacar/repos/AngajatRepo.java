package com.example.rentacar.repos;

import com.example.rentacar.domain.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngajatRepo extends JpaRepository<Angajat, Integer> {
    List<Angajat> findAll();
}
