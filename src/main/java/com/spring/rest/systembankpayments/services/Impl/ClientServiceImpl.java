package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public List<Client> findAll() {
        List<Client> all = clientRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Client findById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        assert client != null;
        client.setFirstName(client.getFirstName().toLowerCase(Locale.ROOT));
        client.setLastName(client.getLastName().toLowerCase(Locale.ROOT));
        client.setEmail(client.getEmail().toLowerCase(Locale.ROOT));

        return client;
    }

    @Override
    @Transactional
    public Client save(Client object) {
        return clientRepository.save(object);
    }

    @Override
    @Transactional
    public Client deleteById(Long id) {
        clientRepository.deleteById(id);
        return null;
    }
}
