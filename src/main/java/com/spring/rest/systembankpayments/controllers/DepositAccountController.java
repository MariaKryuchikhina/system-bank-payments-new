package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depositAccount")
public class DepositAccountController {

    private final DepositAccountService depositAccount;

    public DepositAccountController(DepositAccountService depositAccount) {
        this.depositAccount = depositAccount;
    }

    @RequestMapping("/getDepositAccount/{id}")
    public DepositAccount getDepositAccount(@PathVariable long id){
        return depositAccount.findById(id);
    }

    @RequestMapping("/showAllDepositAccount")
    public List<DepositAccount> showAllDepositAccount(){
        return depositAccount.findAll();
    }

    @PostMapping("/addDepositAccount")
    public DepositAccount addDepositAccount(@RequestBody DepositAccount deposit){
        return depositAccount.save(deposit);
    }

    @PutMapping("/updateDepositAccount")
    public DepositAccount updateDepositAccount(@RequestBody DepositAccount deposit){
        return depositAccount.save(deposit);
    }

    @DeleteMapping("/closeDepositAccount/{id}")
    public void closeDepositAccount(@PathVariable long id){
        depositAccount.deleteById(id);
    }
}
