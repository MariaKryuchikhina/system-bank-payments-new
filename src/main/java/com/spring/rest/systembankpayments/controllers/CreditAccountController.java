package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.CreditAccountDto;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditAccount")
@AllArgsConstructor
public class CreditAccountController {

    private final CreditAccountService creditAccount;
    private ClientMapper clientMapper;

    @RequestMapping("/getCreditAccount/{id}")
    public CreditAccountDto getCreditAccount(@PathVariable long id){
        return clientMapper.creditAccountToClientDto(creditAccount.findById(id));
    }

    @RequestMapping("/showAllCreditAccount")
    public List<CreditAccountDto> showAllCreditAccount(){
        return clientMapper.creditAccountsDto(creditAccount.findAll());
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
