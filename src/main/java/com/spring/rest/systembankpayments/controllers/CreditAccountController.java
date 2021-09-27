package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.CreditAccountDto;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/creditAccount")
@AllArgsConstructor
public class CreditAccountController {

    private final CreditAccountService creditAccount;

    @RequestMapping("/getCreditAccount/{id}")
    public CreditAccountDto getCreditAccount(@PathVariable long id){
        return creditAccount.findById(id);
    }

    @RequestMapping("/showAllCreditAccount")
    public List<CreditAccountDto> showAllCreditAccount(){
        return creditAccount.findAll();
    }

    @PostMapping("/addCreditAccount")
    public CreditAccountDto addCreditAccount(@Valid @RequestBody CreditAccountDto credit){
        return creditAccount.save(credit);
    }

    @PutMapping("/updateCreditAccount")
    public CreditAccountDto updateCreditAccount(@Valid @RequestBody CreditAccountDto credit){
        return creditAccount.save(credit);
    }

    @DeleteMapping("/closeCreditAccount/{id}")
    public void closeCreditAccount(@PathVariable long id){
        creditAccount.deleteById(id);
    }
}
