package com.example.rentacar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String homePage(Model model){
        return "home";
    }

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
