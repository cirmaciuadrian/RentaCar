package com.example.rentacar.repos;

import com.example.rentacar.domain.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasinaRepo extends JpaRepository<Masina, Integer> {
    @Override
    List<Masina> findAll();
//    List<Masina> findAllMasinaByCategorieId(Integer id);
    List<Masina> findAllByCategoriiMasina_Id(Integer id);
    Optional<Masina> findMasinaByNumarInmatriculare(String numarInmatriculare);
    List<Masina> findAllByEsteInchiriata(boolean esteInchiriata);
}
