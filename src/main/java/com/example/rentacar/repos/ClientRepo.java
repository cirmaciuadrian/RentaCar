package com.example.rentacar.repos;

import com.example.rentacar.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
    Optional<Client> findByCnp(String Cnp);
    Optional<Client> findByEmail(String Email);
}
