package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.ClientAllDto;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private ClientMapper clientMapper;

    @GetMapping
    public List<ClientDto> showAllClient(){
        return clientMapper.clientsToClientDto(clientService.findAll());
    }

    @GetMapping("/getClient/{id}")
    public ClientDto getClient(@PathVariable long id){

        return clientMapper.clientToClientDto(clientService.findById(id));
    }

    @GetMapping("/getFullClient/{id}")
    public ClientAllDto getFullClient(@PathVariable long id){

        return clientMapper.clientAllToClientDto(clientService.findById(id));
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
