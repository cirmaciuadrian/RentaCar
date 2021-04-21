package com.example.rentacar.controllers;

import com.example.rentacar.domain.Angajat;
import com.example.rentacar.services.AngajatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AngajatiController {
    @Autowired
    AngajatiService angajatiService;

    @RequestMapping("/angajati")
    public ModelAndView angajatiList(){
        ModelAndView modelAndView = new ModelAndView("angajati");
        List<Angajat> angajati = angajatiService.findAll();
        modelAndView.addObject("products",angajati);
        return modelAndView;
    }
}
