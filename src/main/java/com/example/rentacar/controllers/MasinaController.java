package com.example.rentacar.controllers;

import com.example.rentacar.domain.ChirieActiva;
import com.example.rentacar.domain.Client;
import com.example.rentacar.domain.Masina;
import com.example.rentacar.repos.CategorieRepo;
import com.example.rentacar.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MasinaController {
    MasinaService masinaService;
    CategorieService categorieService;
    FirmaService firmaService;
    ClientService clientService;
    ChirieActivaService chirieActivaService;
    @Autowired
    public MasinaController(MasinaService masinaService, CategorieService categorieService, FirmaService firmaService, ClientService clientService, ChirieActivaService chirieActivaService) {
        this.masinaService = masinaService;
        this.categorieService = categorieService;
        this.firmaService = firmaService;
        this.clientService = clientService;
        this.chirieActivaService = chirieActivaService;
    }


    @RequestMapping(value = "/masini", method = RequestMethod.GET)
    public String getMasini(@RequestParam(value = "categorieSelectata", required = false) Integer categorieSelectata,
                            @RequestParam(value = "status", required = false) String status,
                            Model model) {

        if (categorieSelectata == null) {
            categorieSelectata = 0;
        }
        if (status == null) {
            status = "toate";
        }
        List<Masina> masini = masinaService.findMasini(categorieSelectata, status);
        var clienti = clientService.findAll();
        clienti = clienti.stream().filter(x->x.getChirieActiva()==null).collect(Collectors.toList());
        var categorii = categorieService.findAll();
        model.addAttribute("categorieSelectata", categorieSelectata);
        model.addAttribute("masini", masini);
        model.addAttribute("categorii", categorii);
        model.addAttribute("status", status);
        model.addAttribute("clienti", clienti);

        return "masini";
    }

    @RequestMapping(value = "/masini/add", method =RequestMethod.GET)
    public String addOrUpdate(@RequestParam(value = "id", required = false) Integer idMasina, Model model) {
        Masina masina = new Masina();
        boolean isUpdate = false;
        if(idMasina!=null){
            masina =  masinaService.findById(idMasina);
            isUpdate = true;
        }
        var firme = firmaService.getAll();
        model.addAttribute("isUpdate",isUpdate);
        model.addAttribute("masina", masina);
        model.addAttribute("firme", firme);
        return "carfrom";
    }

    @GetMapping("/masina/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("masina",
                masinaService.findById(Integer.valueOf(id)));
        return "info";
    }

    @PostMapping(value="masini/add")
    public String add(@Valid @ModelAttribute("masina") Masina masina, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            var isUpdate =false;
            var firme=firmaService.getAll();
            model.addAttribute("isUpdate",isUpdate);
            model.addAttribute("masina", masina);
            model.addAttribute("firme", firme);
            return "carfrom";
        }
        if (masinaService.existaNrInamtriculare(masina.getNumarInmatriculare())) {
            bindingResult.addError(new FieldError("masina", "numarInmatriculare", "Numarul de inamtriculare exista in bd"));
            var isUpdate =false;
            var firme=firmaService.getAll();
            model.addAttribute("isUpdate",isUpdate);
            model.addAttribute("masina", masina);
            model.addAttribute("firme", firme);
            return "carfrom";
        }
        masina.setEsteInchiriata(false);
        masinaService.saveOrUpdate(masina);
        return "succes";
    }
    @PreAuthorize("permitAll()")
    @Transactional
    @ResponseBody
    @PostMapping("masina/inchiriaza")
    public String inchiriazaMasina(@RequestParam(value = "idMasina") Integer idMasina,
                                   @RequestParam(value = "idClient") Integer idClient){

        var masina =masinaService.findById(idMasina);
        var client= clientService.findById(idClient);
        ChirieActiva chirieActiva = new ChirieActiva();
        var data  = new Date();
        chirieActiva.setDataInchiriere(data);
        chirieActiva.setClient(client);
        chirieActiva.setMasina(masina);
        masina.setEsteInchiriata(true);
        chirieActivaService.save(chirieActiva);
        return "succes";
    }


}
