package com.spring.rest.systembankpayments.controllers;

import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.services.MainAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainAccount")
@AllArgsConstructor
public class MainAccountController {

    private final MainAccountService mainAccount;

    @GetMapping("/getMainAccount/{id}")
    public MainAccount getMainAccount(@PathVariable long id){
        return mainAccount.findById(id);
    }

    @GetMapping("/showAllMainAccount")
    public List<MainAccount> showAllMainAccount(){
        return mainAccount.findAll();
    }

    @PostMapping("/addNewMainAccount")
    public MainAccount addNewMainAccount(@RequestBody MainAccount main){
        return mainAccount.save(main);
    }

    @PutMapping("/updateMainAccount")
    public MainAccount updateMainAccount(@RequestBody MainAccount main){
        return mainAccount.save(main);
    }

    @DeleteMapping("/closeMainAccount/{id}")
    public void closeMainAccount(@PathVariable long id){
        mainAccount.deleteById(id);
    }

}
