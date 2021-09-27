package com.spring.rest.systembankpayments.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.services.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ClientService clientService;

    ClientDto client1 = ClientDto.builder()
            .idClient(1).firstName("Lina")
            .lastName("Ivanova")
            .email("lina12@gmail.com")
            .phoneNumber("+789651235412")
            .build();

    ClientDto client2 = ClientDto.builder()
            .idClient(2).firstName("Anton")
            .lastName("Ivanov")
            .email("anton@gmail.com")
            .phoneNumber("+789651232652")
            .build();

    ClientDto client3 = ClientDto.builder()
            .idClient(3).firstName("Ivan")
            .lastName("Petrov")
            .email("ivan@gmail.com")
            .phoneNumber("+789129541287")
            .build();

    @Test
    void showAllClient() throws Exception {
        List<ClientDto> clients = List.of(client1, client2, client3);

        Mockito.when(clientService.findAll()).thenReturn(clients);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/client/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[1].firstName", is("Anton")));
    }

//    @Test
//    void getClient() throws Exception {
//        Mockito.when(clientService.findById(client1.getIdClient())).thenReturn(client1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/client/getClient/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstName", is("Anna")));
//    }

//    @Test
//    void addNewClient() throws Exception {
//
//        ClientDto client = ClientDto.builder()
//                .idClient(1)
//                .firstName("Lera")
//                .lastName("Filina")
//                .phoneNumber("89886756")
//                .email("lera@gmail.com")
//                .build();
//
//        Mockito.when(clientService.save(client)).thenReturn(client);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .post("/client/addNewClient")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(client));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
////                .andExpect(jsonPath("$", notNullValue()))
////                .andExpect(jsonPath("$[0].firstName", is("Lera")));
//    }

//    @Test
//    void updateClient() throws Exception {
//        ClientDto client = ClientDto.builder()
//                .idClient(1)
//                .firstName("Lera")
//                .lastName("Filina")
//                .phoneNumber("89886756")
//                .email("lera@gmail.com")
//                .build();
//
//        Mockito.when(clientService.findById(client.getIdClient())).thenReturn(client);
//        Mockito.when(clientService.save(client)).thenReturn(client);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .put("/client/updateClient")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(client));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void deleteClient() throws Exception {
//        Mockito.when(clientService.findById(client1.getIdClient())).thenReturn(client1);
//        mockMvc.perform(MockMvcRequestBuilders
//                .delete("/client/deleteClient/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
}