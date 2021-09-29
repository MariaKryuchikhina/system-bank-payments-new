package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.dto.ClientAllDto;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.exceptions.ClientNotFoundException;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import com.spring.rest.systembankpayments.validations.ClientValidation;
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
    public List<ClientDto> findAll()  throws ClientNotFoundException {
        if(clientRepository.findAll().isEmpty()){
            log.error("Нет клиентов!");
            throw new ClientNotFoundException();
        }
        else{
            log.info("Вывод всех клиентов");
            return clientMapper.clientsToClientDto(clientRepository.findAll());
        }

    }

    @Override
    @Transactional
    public ClientAllDto findById(Long id) throws ClientNotFoundException {
        if(clientRepository.findById(id).isEmpty()) {
            log.error("Клиента с id: {} не существует", id);
            throw new ClientNotFoundException("Клиента не найден!");
        }
        else{
            log.info("Вывод клиента с id: {}", id);
            return clientMapper.clientAllToClientDto(clientRepository.getById(id));
        }
    }

    @Override
    @Transactional
    public ClientDto save(ClientDto object) {

            log.info("Информация о клиенте {} сохранена!", object);
            return clientMapper.clientToClientDto(clientRepository.save(clientMapper.clientDtoToClient(object)));

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(clientRepository.findById(id).isEmpty()) {
            log.error("Клиента с id: {} не существует", id);
            throw new ClientNotFoundException("Клиента не найден!");
        }
        else{
            log.info("Удаление клиента с id: {}", id);
            clientRepository.deleteById(id);
        }
    }
}
