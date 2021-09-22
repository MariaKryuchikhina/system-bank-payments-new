package com.spring.rest.systembankpayments.services;

import com.spring.rest.systembankpayments.dto.ClientAllDto;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.entity.Client;

import java.util.List;

public interface ClientService{

    List<ClientDto> findAll();

    ClientAllDto findById(Long id);

    ClientDto save(ClientDto object);

    void deleteById(Long id);
}
