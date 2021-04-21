package com.example.rentacar.repos;

import com.example.rentacar.domain.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepo extends JpaRepository<Firma, Integer> {
}
