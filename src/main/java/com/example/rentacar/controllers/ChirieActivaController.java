package com.example.rentacar.controllers;

import com.example.rentacar.domain.ChirieActiva;
import com.example.rentacar.domain.ChirieFinalizata;
import com.example.rentacar.domain.Client;
import com.example.rentacar.services.ChirieActivaService;
import com.example.rentacar.services.ChirieFinalizataService;
import com.example.rentacar.services.ClientService;
import com.example.rentacar.services.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Controller
public class ChirieActivaController {
    ChirieActivaService chirieActivaService;
    MasinaService masinaService;
    ClientService clientService;
    ChirieFinalizataService chirieFinalizataService;

    @Autowired
    public ChirieActivaController(ChirieActivaService chirieActivaService, ClientService clientService, MasinaService masinaService, ChirieFinalizataService chirieFinalizataService) {
        this.chirieActivaService = chirieActivaService;
        this.clientService = clientService;
        this.masinaService = masinaService;
        this.chirieFinalizataService = chirieFinalizataService;
    }

    @RequestMapping(value = "/chirie/active", method = RequestMethod.GET)
    public String getAll(Model model) {
        var chiriiActive = chirieActivaService.getAll();
        model.addAttribute("chiriiActive", chiriiActive);
        return "chirieActiva";
    }

    @ResponseBody
    @RequestMapping(value = "/chirie/getpret", method = RequestMethod.GET)
    public String getPret(@RequestParam(value = "idClient") Integer idClient,
                          @RequestParam(value = "idMasina") Integer idMasina,
                          @RequestParam(value = "idChirieActiva") Integer idChirieActiva) {
        var masina = masinaService.findById(idMasina);
        var client = clientService.findById(idClient);
        var chirieActiva = chirieActivaService.findById(idChirieActiva);
        var pret = masina.getPret();
        var dataInceput = chirieActiva.getDataInchiriere();
        LocalDate dataFinalizare = LocalDate.now();
        LocalDate dataInchiriereConvertita = dataInceput.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        var zile = Period.between(dataInchiriereConvertita, dataFinalizare).getDays();
        pret = pret * zile + pret;
        return pret.toString();
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/chirii/finalizeaza", method = RequestMethod.POST)
    public String finalizeazaChirie(@RequestParam(value = "idClient") Integer idClient,
                                    @RequestParam(value = "idMasina") Integer idMasina,
                                    @RequestParam(value = "idChirieActiva") Integer idChirieActiva,
                                    @RequestParam(value = "pret") Float pret){
        var chirieFinalizata = new ChirieFinalizata();
        var chirieActiva = chirieActivaService.findById(idChirieActiva);
        var client = clientService.findById(idClient);
        var masina = masinaService.findById(idMasina);
        chirieFinalizata.setClient(client);
        chirieFinalizata.setMasina(masina);
        chirieFinalizata.setDataInceput(chirieActiva.getDataInchiriere());
        chirieFinalizata.setDataSfarsit(new Date());
        chirieFinalizata.setPretTotal(pret);
        chirieFinalizata.getMasina().setEsteInchiriata(false);
        chirieFinalizataService.save(chirieFinalizata);
        chirieActivaService.delete(chirieActiva.getId());
        return "succes";
    }


}
