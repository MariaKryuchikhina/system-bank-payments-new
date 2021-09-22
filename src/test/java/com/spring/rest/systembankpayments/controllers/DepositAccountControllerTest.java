package com.spring.rest.systembankpayments.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(DepositAccountController.class)
//class DepositAccountControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    DepositAccountService depositAccountService;
//
//    Date date1 = new Date();
//    Date date2 = new Date();
//    Date date3 = new Date();
//
//    DepositAccount depositAccount1 = new DepositAccount(1L, "5635454687687685", date1,
//            TypeAccount.DEPOSIT, 120000, 0.15);
//    DepositAccount depositAccount2 = new DepositAccount(2L, "3443254797865312", date2,
//            TypeAccount.DEPOSIT, 120000, 0.15);
//    DepositAccount depositAccount3 = new DepositAccount(3L, "1323247800096764", date3,
//            TypeAccount.DEPOSIT, 120000, 0.15);
//
//    @Test
//    void getDepositAccount() throws Exception {
//        Mockito.when(depositAccountService.findById(depositAccount1.getId())).thenReturn(depositAccount1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/depositAccount/getDepositAccount/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void showAllDepositAccount() throws Exception {
//        List<DepositAccount> accounts = List.of(depositAccount1, depositAccount2, depositAccount3);
//
//        Mockito.when(depositAccountService.findAll()).thenReturn(accounts);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/depositAccount/showAllDepositAccount")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void addDepositAccount() throws Exception {
//        Date date = new Date();
//        DepositAccount account = DepositAccount.builder()
//                .id(3L)
//                .amount(6000000)
//                .expirationDate(date)
//                .number("84575683274392572")
//                .type(TypeAccount.DEPOSIT)
//                .interestRate(0.20)
//                .build();
//
//        Mockito.when(depositAccountService.save(account)).thenReturn(account);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .post("/depositAccount/addDepositAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(account));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void updateDepositAccount() throws Exception {
//        Date date = new Date();
//        DepositAccount account = DepositAccount.builder()
//                .id(3L)
//                .amount(6000000)
//                .expirationDate(date)
//                .number("84575683274392572")
//                .type(TypeAccount.DEPOSIT)
//                .interestRate(0.20)
//                .build();
//
//        Mockito.when(depositAccountService.findById(account.getId())).thenReturn(account);
//        Mockito.when(depositAccountService.save(account)).thenReturn(account);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .put("/depositAccount/updateDepositAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(account));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void closeDepositAccount() throws Exception {
//        Mockito.when(depositAccountService.findById(depositAccount1.getId())).thenReturn(depositAccount1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .delete("/depositAccount/closeDepositAccount/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//}