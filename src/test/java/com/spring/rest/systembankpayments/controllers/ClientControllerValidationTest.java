package com.spring.rest.systembankpayments.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring.rest.systembankpayments.dto.ClientDto;
import com.spring.rest.systembankpayments.services.ClientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerValidationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper mapper;

    @MockBean
    ClientService clientService;


//    @BeforeAll
//    static void setUp() {
//        mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature., false);
//    }
//
//    @Test
//    void add() throws Exception {
//
//        ClientDto client1 = ClientDto.builder()
//                .idClient(1).firstName("Lina")
//                .lastName("Ivanova")
//                .email("lina12@gmail.com")
//                .phoneNumber("+789651235412")
//                .build();
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/client/addNewClient")
//                        .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(client1)))
//                .andExpect(status().isOk());
//    }
}