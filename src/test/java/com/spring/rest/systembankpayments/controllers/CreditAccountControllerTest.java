package com.spring.rest.systembankpayments.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.services.CreditAccountService;
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

//@WebMvcTest(CreditAccountController.class)
//class CreditAccountControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    CreditAccountService creditAccountService;
//
//    Date date1 = new Date();
//    Date date2 = new Date();
//    Date date3 = new Date();
//
//    CreditAccount creditAccount1 = new CreditAccount(1L, "786534783952", date1, TypeAccount.CREDIT,
//            3000000, 0.15, 500000, 0.20);
//    CreditAccount creditAccount2 = new CreditAccount(2L, "090754342435", date2, TypeAccount.CREDIT,
//            290000, 0.08, 4600000, 0.15);
//    CreditAccount creditAccount3 = new CreditAccount(3L, "864354689876", date3, TypeAccount.CREDIT,
//            50000, 0.05, 4540, 0.10);
//
//    @Test
//    void getCreditAccount() throws Exception {
//        Mockito.when(creditAccountService.findById(creditAccount1.getId())).thenReturn(creditAccount1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/creditAccount/getCreditAccount/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk());
//    }
//
//    @Test
//    void showAllCreditAccount() throws Exception {
//        List<CreditAccount> accounts = List.of(creditAccount1, creditAccount2, creditAccount3);
//
//        Mockito.when(creditAccountService.findAll()).thenReturn(accounts);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/creditAccount/showAllCreditAccount")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk());
//    }
//
//    @Test
//    void addCreditAccount() throws Exception {
//        Date date = new Date();
//
//        CreditAccount credit = CreditAccount.builder()
//                .id(2L)
//                .creditLimit(120000)
//                .expirationDate(date)
//                .number("858976349873580349676")
//                .type(TypeAccount.CREDIT)
//                .accruedInterest(0.12)
//                .interestRate(0.15)
//                .currentDebt(50000)
//                .build();
//
//        Mockito.when(creditAccountService.save(credit)).thenReturn(credit);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .post("/creditAccount/addCreditAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(credit));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void updateCreditAccount() throws Exception {
//        Date date = new Date();
//
//        CreditAccount credit = CreditAccount.builder()
//                .id(2L)
//                .creditLimit(120000)
//                .expirationDate(date)
//                .number("858976349873580349676")
//                .type(TypeAccount.CREDIT)
//                .accruedInterest(0.12)
//                .interestRate(0.15)
//                .currentDebt(50000)
//                .build();
//
//        Mockito.when(creditAccountService.findById(creditAccount1.getId())).thenReturn(creditAccount1);
//        Mockito.when(creditAccountService.save(credit)).thenReturn(credit);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .put("/creditAccount/updateCreditAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(credit));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void closeCreditAccount() throws Exception {
//        Mockito.when(creditAccountService.findById(creditAccount1.getId())).thenReturn(creditAccount1);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/creditAccount/closeCreditAccount/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk());
//    }
//}