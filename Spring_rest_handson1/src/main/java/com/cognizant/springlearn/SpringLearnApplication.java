package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();
        displayCountry();
        displayCountries();
        LOGGER.info("END");
    }

    public static void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Unable to parse date", e);
        }

        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END");
    }

    public static void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Singleton country #1: {}", country);
        LOGGER.debug("Singleton country #2: {}", anotherCountry);
        LOGGER.debug("Singleton same instance: {}", country == anotherCountry);

        Country prototypeCountry1 = context.getBean("countryPrototype", Country.class);
        Country prototypeCountry2 = context.getBean("countryPrototype", Country.class);
        LOGGER.debug("Prototype country #1: {}", prototypeCountry1);
        LOGGER.debug("Prototype country #2: {}", prototypeCountry2);
        LOGGER.debug("Prototype same instance: {}", prototypeCountry1 == prototypeCountry2);

        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END");
    }

    public static void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> countries = context.getBean("countryList", List.class);
        LOGGER.debug("Countries: {}", countries);

        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END");
    }
}
