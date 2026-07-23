package com.cognizant.loan.service;

import org.springframework.stereotype.Service;

import com.cognizant.loan.model.Loan;

@Service
public class LoanService {

    public Loan getLoan(String number) {

        return new Loan(
                number,
                "Car Loan",
                400000,
                3258,
                18
        );

    }

}