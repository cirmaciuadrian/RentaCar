package com.example.rentacar.controllers;

import com.example.rentacar.services.ChirieFinalizataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChirieFinalizataController {
    ChirieFinalizataService chirieFinalizataService;

    @Autowired
    public ChirieFinalizataController(ChirieFinalizataService chirieFinalizataService){
        this.chirieFinalizataService = chirieFinalizataService;
    }

    @RequestMapping("chirie/finalizate")
    public String getAll (Model model){
        var chiriiFinalizate =  chirieFinalizataService.getAll();
        model.addAttribute("chiriiFinalizate", chiriiFinalizate);
        return "chiriiFinalizate";
    }
}
