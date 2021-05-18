package com.example.rentacar.controllers;

import com.example.rentacar.domain.Angajat;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.services.AngajatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AngajatiController {
    @Autowired
    AngajatiService angajatiService;

    @RequestMapping("/angajati")
    public String angajatiList(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "sortBy", required = false) String sortBy,
                               @RequestParam(value = "sortType", required = false) String sortType, Model model) {
        int size = 5;
        if (page == null)
            page = 1;
        if(sortBy==null)
            sortBy ="nume";
        if(sortType==null)
            sortType ="asc";
        Page<Angajat> pageAngajat = angajatiService.findAll(page, size, sortBy, sortType);
        List<Angajat> angajati = pageAngajat.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageAngajat.getTotalPages());
        model.addAttribute("totalItems", pageAngajat.getTotalElements());

        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortType", sortType);
        model.addAttribute("reverseSortDir", sortType.equals("asc") ? "desc" : "asc");
        model.addAttribute("angajati", angajati);
        var angajat = new Angajat();
        model.addAttribute("angajat", angajat);
        return "angajati";
    }

    @PostMapping("/angajati/add")
    public String saveOrUpdate(@Valid @ModelAttribute("angajat") Angajat angajat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addangajat";
        }
        var cnp = angajat.getCnp();
        if (angajatiService.existaCnp(cnp)) {
            bindingResult.addError(new FieldError("angajat", "cnp", "Cnp-ul exista in baza de date"));
            return "addangajat";
        }

        Angajat savedAngajat = angajatiService.save(angajat);
        return "redirect:/angajati";
    }

    @RequestMapping("/angajati/add")
    public String newAngajat(Model model) {
        model.addAttribute("angajat", new Angajat());
        return "addangajat";
    }

    @RequestMapping("/angajati/delete/{id}")
    public String deleteById(@PathVariable String id) {
        angajatiService.deleteById(Integer.valueOf(id));
        return "redirect:/angajati";
    }

}
