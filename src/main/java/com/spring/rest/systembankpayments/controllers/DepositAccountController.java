package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.DepositAccountDto;
import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depositAccount")
@AllArgsConstructor
public class DepositAccountController {

    private final DepositAccountService depositAccount;

    @RequestMapping("/getDepositAccount/{id}")
    public DepositAccountDto getDepositAccount(@PathVariable long id){
        return depositAccount.findById(id);
    }

    @RequestMapping("/showAllDepositAccount")
    public List<DepositAccountDto> showAllDepositAccount(){
       return depositAccount.findAll();
    }

    @PostMapping("/addDepositAccount")
    public DepositAccountDto addDepositAccount(@RequestBody DepositAccountDto deposit){
        return depositAccount.save(deposit);
    }

    @PutMapping("/updateDepositAccount")
    public DepositAccountDto updateDepositAccount(@RequestBody DepositAccountDto deposit){
        return depositAccount.save(deposit);
    }

    @DeleteMapping("/closeDepositAccount/{id}")
    public void closeDepositAccount(@PathVariable long id){
        depositAccount.deleteById(id);
    }
}
