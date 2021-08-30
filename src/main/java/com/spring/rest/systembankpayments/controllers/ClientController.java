package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public Client getClients(@PathVariable long id){
        Client client = new Client();
        client.setIdClient(123456);
        client.setEmail("qw12@gmail.com");
        client.setFirstName("Maria");
        client.setLastName("Qwe");
        client.setPhoneNumber("454353");
        return client;
    }

    @RequestMapping("/")
    public List<Client> showAllClient(){
        List<Client> allClient = clientService.findAll();
        return allClient;
    }

    @RequestMapping("/get/{id}")
    public Client getClient(@PathVariable long id){
        Client client = clientService.findById(id);
        return client;
    }

    @PostMapping("/add")
    public Client addNewClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return  clientService.save(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteById(id);
    }

}
