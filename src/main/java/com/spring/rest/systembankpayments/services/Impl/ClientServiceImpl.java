package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client save(Client object) {
        return clientRepository.save(object);
    }

    @Override
    @Transactional
    public void delete(Client object) {
        clientRepository.delete(object);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
