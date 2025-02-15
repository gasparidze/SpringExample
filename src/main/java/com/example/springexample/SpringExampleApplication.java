package com.example.springexample;

import com.example.springexample.model.Client;
import com.example.springexample.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringExampleApplication.class , args);
        ClientService bean = context.getBean(ClientService.class);
        Client newClient = Client.builder()
                .fio("New Client Fio")
                .phone("8918")
                .birthDate(LocalDate.now())
                .email("newTest@mail.ru")
                .build();

        Client client = bean.create(newClient);
        System.out.println(client);
    }

}
