package com.example.rentacar.controllers;

import com.example.rentacar.domain.Masina;
import com.example.rentacar.repos.CategorieRepo;
import com.example.rentacar.services.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MasinaControllerTest {
    @Mock
    Model model;
    @Mock
    MasinaService masinaService;
    @Mock
    CategorieService categorieService;
    @Mock
    FirmaService firmaService;
    @Mock
    ClientService clientService;
    @Mock
    ChirieActivaService chirieActivaService;

    MasinaController masinaController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        masinaController = new MasinaController(masinaService, categorieService, firmaService, clientService, chirieActivaService);
    }

    @Captor
    ArgumentCaptor<Masina> argumentCaptor;


    @Test
    public void showById() {
        Integer id = 1;
        Masina masinaTest = new Masina();
        masinaTest.setId(id);

        when(masinaService.findById(id)).thenReturn(masinaTest);

        String viewName = masinaController.showById(id.toString(), model);
        Assert.assertEquals("info", viewName);
        verify(masinaService, times(1)).findById(id);

        verify(model, times(1))
                .addAttribute(eq("masina"), argumentCaptor.capture() );

        Masina masinaArg = argumentCaptor.getValue();
        Assert.assertEquals(masinaArg.getId(), masinaTest.getId() );

    }
}
