package com.cognizant.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.loan.model.Loan;
import com.cognizant.loan.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number) {

        return service.getLoan(number);

    }

}