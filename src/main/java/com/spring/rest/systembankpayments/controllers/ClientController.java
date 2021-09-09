package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.services.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> showAllClient(){
        return clientService.findAll();
    }

    @RequestMapping("/getClient/{id}")
    public Client getClient(@PathVariable long id){
        return clientService.findById(id);
    }

    @PostMapping("/addNewClient")
    public Client addNewClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client){
        return  clientService.save(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteById(id);
    }

}
