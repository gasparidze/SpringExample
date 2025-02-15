package com.example.springexample.service;

import com.example.springexample.model.Client;
import com.example.springexample.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client findById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client create(Client client){
        return clientRepository.save(client);
    }
}
