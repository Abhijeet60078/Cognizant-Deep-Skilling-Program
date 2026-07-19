package com.cognizant.springlearn.dao;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {

    public Country getCountry() {

        Country country = new Country();
        country.setCode("IN");
        country.setName("India");

        return country;
    }
}