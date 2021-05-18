package com.example.rentacar.controllers;

import com.example.rentacar.domain.ExceptiiLoguri;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.repos.ExceptiiLoguriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ExceptiiLoguriRepo exceptiiLoguriRepo;
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handlerNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("notFound");
        ExceptiiLoguri exceptiiLoguri = new ExceptiiLoguri();
        exceptiiLoguri.setMesaj(exception.getMessage());
        exceptiiLoguri.setExceptie(exception.toString());
        exceptiiLoguriRepo.save(exceptiiLoguri);
        modelAndView.getModel().put("exception",exception);
        return modelAndView;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView NohandlerNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("notFound");
        ExceptiiLoguri exceptiiLoguri = new ExceptiiLoguri();
        exceptiiLoguri.setMesaj(exception.getMessage());
        exceptiiLoguri.setExceptie(exception.toString());
        exceptiiLoguriRepo.save(exceptiiLoguri);
        modelAndView.getModel().put("exception",exception);
        return modelAndView;
    }
}

