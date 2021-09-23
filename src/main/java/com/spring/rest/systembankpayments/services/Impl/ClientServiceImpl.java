package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.dto.ClientAllDto;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public List<ClientDto> findAll() {
        log.info("Вывод всех клиентов");
        return clientMapper.clientsToClientDto(clientRepository.findAll());
    }

    @Override
    @Transactional
    public ClientAllDto findById(Long id) {
        return clientMapper.clientAllToClientDto(clientRepository.getById(id));
    }

    @Override
    @Transactional
    public ClientDto save(ClientDto object) {
        return clientMapper.clientToClientDto(clientRepository.save(clientMapper.clientDtoToClient(object)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
