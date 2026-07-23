package com.cognizant.account.service;

import org.springframework.stereotype.Service;

import com.cognizant.account.model.Account;

@Service
public class AccountService {

    public Account getAccount(String number) {

        return new Account(
                number,
                "Savings",
                250000.00
        );

    }

}