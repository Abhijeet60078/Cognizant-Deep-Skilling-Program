package com.cognizant.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.account.model.Account;
import com.cognizant.account.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/{number}")
    public Account getAccount(@PathVariable String number) {

        return service.getAccount(number);

    }

}