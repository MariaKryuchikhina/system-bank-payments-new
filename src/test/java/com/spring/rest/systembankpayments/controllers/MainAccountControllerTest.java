package com.spring.rest.systembankpayments.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.services.MainAccountService;
import liquibase.pro.packaged.M;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

//@WebMvcTest(MainAccountController.class)
//class MainAccountControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    MainAccountService mainAccountService;
//
//    Date date1 = new Date();
//    Date date2 = new Date();
//    Date date3 = new Date();
//
//    MainAccount main1 = new MainAccount(1, "6465354364346", date1,
//            TypeAccount.MAIN, 200000);
//    MainAccount main2 = new MainAccount(2, "89687647675553", date2,
//            TypeAccount.MAIN, 500000);
//    MainAccount main3 = new MainAccount(3, "21345768776987", date3,
//            TypeAccount.MAIN, 120000);
//
//    @Test
//    void getMainAccount() throws Exception {
//        Mockito.when(mainAccountService.findById(main1.getId())).thenReturn(main1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/mainAccount/getMainAccount/3")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void showAllMainAccount() throws Exception {
//        List<MainAccount> accounts = List.of(main1, main2, main3);
//
//        Mockito.when(mainAccountService.findAll()).thenReturn(accounts);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/mainAccount/showAllMainAccount")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void addNewMainAccount() throws Exception {
//        Date date = new Date();
//        MainAccount account = MainAccount.builder()
//                .id(2)
//                .type(TypeAccount.MAIN)
//                .number("87654345678909865")
//                .expirationDate(date)
//                .amount(1200000)
//                .build();
//
//        Mockito.when(mainAccountService.save(account)).thenReturn(account);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .post("/mainAccount/addNewMainAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(account));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void updateMainAccount() throws Exception {
//        Date date = new Date();
//        MainAccount account = MainAccount.builder()
//                .id(2)
//                .type(TypeAccount.MAIN)
//                .number("87654345678909865")
//                .expirationDate(date)
//                .amount(1200000)
//                .build();
//
//        Mockito.when(mainAccountService.findById(account.getId())).thenReturn(account);
//        Mockito.when(mainAccountService.save(account)).thenReturn(account);
//
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
//                .put("/mainAccount/updateMainAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(account));
//
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void closeMainAccount() throws Exception {
//        Mockito.when(mainAccountService.findById(main1.getId())).thenReturn(main1);
//        mockMvc.perform(MockMvcRequestBuilders
//                .delete("/mainAccount/closeMainAccount/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}