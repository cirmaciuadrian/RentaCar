package com.example.rentacar.repos;

import com.example.rentacar.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Integer> {
}
