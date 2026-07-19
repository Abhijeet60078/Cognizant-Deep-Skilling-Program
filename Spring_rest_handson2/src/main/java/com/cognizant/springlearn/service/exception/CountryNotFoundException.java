package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Country Not found")
public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String code) {
        super("Country not found for code: " + code);
    }
}
