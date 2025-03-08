package com.example.springexample.service;

import com.example.springexample.model.Client;
import com.example.springexample.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {
    private final ClientRepository clientRepository;

    public Client findById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    @Transactional
    public Client create(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findByBirthDateOrFio(LocalDate birthday, String fio){
        return clientRepository.findClientByBirthDateOrFio(birthday, fio);
    }

    @Transactional
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    @Transactional
    public void updatePhoneByIdHQL(String phone, Integer id){
        clientRepository.updatePhoneById(phone, id);
    }

    @Transactional
    public void updatePhoneById(String phone, Integer id){
        clientRepository.updatePhoneByIdHQL(phone, id);
    }
}