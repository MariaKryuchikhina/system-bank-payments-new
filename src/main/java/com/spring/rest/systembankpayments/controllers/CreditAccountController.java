package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditAccount")
public class CreditAccountController {

    private final CreditAccountService creditAccount;

    public CreditAccountController(CreditAccountService creditAccount) {
        this.creditAccount = creditAccount;
    }

    @RequestMapping("/getCreditAccount/{id}")
    public CreditAccount getCreditAccount(@PathVariable long id){
        return creditAccount.findById(id);
    }

    @RequestMapping("/showAllCreditAccount")
    public List<CreditAccount> showAllCreditAccount(){
        return creditAccount.findAll();
    }

    @PostMapping("/addCreditAccount")
    public CreditAccount addCreditAccount(@RequestBody CreditAccount credit){
        return creditAccount.save(credit);
    }

    @PutMapping("/updateCreditAccount")
    public CreditAccount updateCreditAccount(@RequestBody CreditAccount credit){
        return creditAccount.save(credit);
    }

    @DeleteMapping("/closeCreditAccount/{id}")
    public void closeCreditAccount(@PathVariable long id){
        creditAccount.deleteById(id);
    }
}
