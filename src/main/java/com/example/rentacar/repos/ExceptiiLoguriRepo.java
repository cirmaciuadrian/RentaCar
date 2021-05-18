package com.example.rentacar.repos;

import com.example.rentacar.domain.Client;
import com.example.rentacar.domain.ExceptiiLoguri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptiiLoguriRepo extends JpaRepository<ExceptiiLoguri, Integer> {
}
