package com.example.rentacar.services;

import com.example.rentacar.domain.Categorie;
import com.example.rentacar.domain.Masina;
import com.example.rentacar.repos.CategorieRepo;
import com.example.rentacar.repos.MasinaRepo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MasinaServiceTest {
    MasinaService masinaService;

    @Mock
    MasinaRepo masinaRepo;

    @Mock
    CategorieRepo categorieRepo;
    
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        masinaService = new MasinaServiceImpl(masinaRepo,categorieRepo);
    }

    @Test
    public void findMasiniDinCategorie() {
        List<Masina> masinaList = new ArrayList<Masina>();
        Categorie categorie = new Categorie();
        categorie.setCategorie("Sport");
        categorie.setId(1);
        Optional<Categorie> categorie2 = Optional.of(categorie);
        Masina masina = new Masina();
        masina.setCategoriiMasina(Arrays.asList(categorie));
        masina.setId(1);
        masina.setAnProductie(2010);
        masinaList.add(masina);

        when(masinaRepo.findAllByCategoriiMasina_Id(1)).thenReturn(masinaList);
        when(categorieRepo.findById(1)).thenReturn(categorie2);
        List<Masina> masini = masinaService.findAllByCategorie(1);
        assertEquals(masini.size(), 1);
        verify(masinaRepo, times(1)).findAllByCategoriiMasina_Id(1);
        verify(categorieRepo, times(1)).findById(1);
    }

}
