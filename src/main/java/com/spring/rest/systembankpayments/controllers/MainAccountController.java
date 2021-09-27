package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.dto.MainAccountDto;
import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.mapper.ClientMapper;
import com.spring.rest.systembankpayments.services.MainAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mainAccount")
@AllArgsConstructor
public class MainAccountController {

    private final MainAccountService mainAccount;

    @GetMapping("/getMainAccount/{id}")
    public MainAccountDto getMainAccount(@PathVariable long id){
        return mainAccount.findById(id);
    }

    @GetMapping("/showAllMainAccount")
    public List<MainAccountDto> showAllMainAccount(){
        return mainAccount.findAll();
    }

    @PostMapping("/addNewMainAccount")
    public MainAccountDto addNewMainAccount(@Valid @RequestBody MainAccountDto main){
        return mainAccount.save(main);
    }

    @PutMapping("/updateMainAccount")
    public MainAccountDto updateMainAccount(@Valid @RequestBody MainAccountDto main){
        return mainAccount.save(main);
    }

    @DeleteMapping("/closeMainAccount/{id}")
    public void closeMainAccount(@PathVariable long id){
        mainAccount.deleteById(id);
    }

}
