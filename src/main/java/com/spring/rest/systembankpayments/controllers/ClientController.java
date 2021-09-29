package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.ClientAllDto;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.exceptions.ClientNotFoundException;
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

    @GetMapping
    public List<ClientDto> showAllClient() throws ClientNotFoundException{
        return clientService.findAll();
    }

    @GetMapping("/getClient/{id}")
    public ClientAllDto getClient(@PathVariable long id) throws ClientNotFoundException {
        return clientService.findById(id);
    }

    @PostMapping("/addNewClient")
    public ClientDto addNewClient(@RequestBody ClientDto client){
        return clientService.save(client);
    }

    @PutMapping("/updateClient")
    public ClientDto updateClient(@Valid @RequestBody ClientDto client){
        return  clientService.save(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable long id) throws ClientNotFoundException {
        clientService.deleteById(id);
    }

}
