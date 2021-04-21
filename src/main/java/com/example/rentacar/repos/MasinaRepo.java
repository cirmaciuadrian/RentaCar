package com.example.rentacar.repos;

import com.example.rentacar.domain.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepo extends JpaRepository<Masina, Integer> {
}
