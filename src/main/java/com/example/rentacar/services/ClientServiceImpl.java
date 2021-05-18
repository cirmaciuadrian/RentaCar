package com.example.rentacar.services;

import com.example.rentacar.domain.Client;
import com.example.rentacar.exceptions.ResourceNotFoundException;
import com.example.rentacar.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client findById(Integer Id) {
        Optional<Client> clientOptional = clientRepo.findById(Id);
        if (!clientOptional.isPresent()) {
            throw new ResourceNotFoundException("Clientul nu a fost gasit!");
        }
        return clientOptional.get();
    }

    @Override
    public Client findByCnp(String Cnp){
        Optional<Client> clientOptional = clientRepo.findByCnp(Cnp);
        if (!clientOptional.isPresent()) {
            throw new ResourceNotFoundException("Clientul cu cnp-ul "+Cnp+" nu fost gasit!");
        }
        return clientOptional.get();
    }

    @Override
    public boolean existaCnp (String Cnp){
        Optional<Client> clientOptional = clientRepo.findByCnp(Cnp);
        if(clientOptional.isPresent())
            return true;
        return false;
    }
    @Override
    public void save(Client client){
        Client savedClient = clientRepo.save(client);
    }
    @Override
    public boolean existaEmail(String email){
        Optional<Client> clientOptional = clientRepo.findByEmail(email);
        if(clientOptional.isPresent())
            return true;
        return false;
    }
}
