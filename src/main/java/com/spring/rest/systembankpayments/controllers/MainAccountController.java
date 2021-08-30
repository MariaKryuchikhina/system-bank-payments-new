package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.services.ClientService;
import com.spring.rest.systembankpayments.services.MainAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MainAccountController {

    @Autowired
    private MainAccountService mainAccountService;

    @Autowired
    private ClientService clientService;

    public MainAccount showMainAccount(@PathVariable long id){
        MainAccount mainAccount = mainAccountService.findById(id);
        return mainAccount;
    }



}
