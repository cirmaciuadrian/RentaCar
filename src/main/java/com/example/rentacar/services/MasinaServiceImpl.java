package com.example.rentacar.services;

import com.example.rentacar.domain.Masina;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.repos.CategorieRepo;
import com.example.rentacar.repos.MasinaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MasinaServiceImpl implements MasinaService {
    MasinaRepo masinaRepo;
    CategorieRepo categorieRepo;

    @Autowired
    public MasinaServiceImpl(MasinaRepo masinaRepo, CategorieRepo categorieRepo) {
        this.masinaRepo = masinaRepo;
        this.categorieRepo = categorieRepo;
    }

    @Override
    public List<Masina> findMasini(Integer categorieSelectata, String status) {
        List<Masina> masini;
        if (categorieSelectata == 0)
            masini = masinaRepo.findAll();
        else masini = findAllByCategorie(categorieSelectata);
        if (!status.equals("toate"))
            if (status.equals("inchiriate")) {
                masini = masini.stream().filter(x -> x.getEsteInchiriata() == true).collect(Collectors.toList());
            } else {
                masini = masini.stream().filter(x -> x.getEsteInchiriata() == false).collect(Collectors.toList());
            }
        return masini;
    }

    @Override
    public Masina findById(Integer id) {
        Optional<Masina> masinaOptional = masinaRepo.findById(id);
        if (!masinaOptional.isPresent())
            throw new ResourceNotFoundException("Masina cu id-ul " + id + " nu fost gasita!");
        return masinaOptional.get();
    }

    @Override
    public List<Masina> findAllByCategorie(Integer id) {
        if (!categorieRepo.findById(id).isPresent())
            throw new ResourceNotFoundException("Categoria nu a fost gasita!");
        return masinaRepo.findAllByCategoriiMasina_Id(id);
    }

    @Override
    public Boolean existaNrInamtriculare(String nrInmatriculare){
        if(masinaRepo.findMasinaByNumarInmatriculare(nrInmatriculare).isPresent())
            return true;
        return false;
    }

    @Override
    public Masina saveOrUpdate(Masina masina){
        return masinaRepo.save(masina);
    }

}
