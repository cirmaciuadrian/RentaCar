package com.example.rentacar.controllers;


import com.example.rentacar.domain.Angajat;
import com.example.rentacar.domain.Client;
import com.example.rentacar.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/clienti")
    public String getAll(Model model) {
        List<Client> clientList = clientService.findAll();
        Client client = new Client();
        model.addAttribute("clienti", clientList);
        model.addAttribute("client", client);
        return "clientiView";
    }
    @RequestMapping(value="/clienti/add",method = RequestMethod.GET)
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "addclient";
    }
    @PostMapping("/clienti/add")
    public String add(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addclient";
        }
        var cnp = client.getCnp();
        if (clientService.existaCnp(cnp)) {
            bindingResult.addError(new FieldError("client", "cnp", "Cnp-ul exista in baza de date"));
            return "addclient";
        }
        if(clientService.existaEmail(client.getEmail()))
        {
            bindingResult.addError(new FieldError("client", "email", "Email-ul exista in baza de date"));
            return "addclient";
        }

        clientService.save(client);
        return "redirect:/clienti";
    }
    @PostMapping("/clienti/update/{id}")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("client") Client client,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            boolean update=true;
            model.addAttribute("update", update);
            return "addclient";
        }
        clientService.save(client);
        return "redirect:/clienti";
    }
    @RequestMapping("/clienti/update/{id}")
    public String updateParticipant(@PathVariable String id, Model model) {
        model.addAttribute("client",
                clientService.findById(Integer.valueOf(id)));
        boolean update=true;
        model.addAttribute("update", update);
        return "addclient";
    }
}
