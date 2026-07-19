# Hands on 1 - Spring Data JPA Quick Example

This folder contains a ready-to-import Maven project for the Spring Data JPA quick example (`orm-learn`).

## Software Pre-requisites

- MySQL Server 8.0
- MySQL Workbench 8
- Eclipse IDE for Enterprise Java Developers 2019-03 R
- Maven 3.6.2

## What Is Included In This Project

- `src/main/java`: Application source code
- `src/main/resources`: Application configuration
- `src/test/java`: Test source code
- `OrmLearnApplication.java`: Main class with startup and test flow
- `@SpringBootApplication`: Enables auto-configuration, component scan, and Spring Boot setup
- `pom.xml`: Maven dependencies and plugins

## Project Setup In Eclipse

1. Open [https://start.spring.io/](https://start.spring.io/) and use:
   - Group: `com.cognizant`
   - Artifact: `orm-learn`
   - Description: `Demo project for Spring Data JPA and Hibernate`
   - Dependencies: `Spring Boot DevTools`, `Spring Data JPA`, `MySQL Driver`
2. Generate and extract the zip into your Eclipse workspace.
3. Import in Eclipse:
   - `File > Import > Maven > Existing Maven Projects`
   - Browse to the extracted folder and click `Finish`.

This repository already includes equivalent generated content in this folder.

## Database Setup

Run these commands in MySQL:

```sql
create schema ormlearn;

use ormlearn;

create table country (
    co_code varchar(2) primary key,
    co_name varchar(50)
);

insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');
```

You can also run the script in `database/setup.sql`.

## Application Configuration

`src/main/resources/application.properties` includes:

- Spring and application logging levels
- Hibernate SQL trace logging
- Console log pattern
- MySQL datasource configuration
- Hibernate DDL and dialect configuration

Default DB credentials currently set:

- Username: `root`
- Password: `root`

Change these values for your local setup if needed.

## Build Command

Use this command if your environment needs proxy settings:

```bash
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
```

If proxy is not required, run:

```bash
mvn clean package
```

## Code Walkthrough

### `Country` entity

- Package: `com.cognizant.ormlearn.model`
- Mapped to table `country`
- Field mappings:
  - `code -> co_code` (primary key)
  - `name -> co_name`

### `CountryRepository`

- Package: `com.cognizant.ormlearn.repository`
- Extends `JpaRepository<Country, String>`
- Provides built-in CRUD methods including `findAll()`

### `CountryService`

- Package: `com.cognizant.ormlearn.service`
- `@Service` class with autowired `CountryRepository`
- `getAllCountries()` method is marked `@Transactional`

### `OrmLearnApplication`

- Starts Spring Boot application
- Logs `Inside main`
- Retrieves `CountryService` bean from application context
- Invokes `testGetAllCountries()`
- Logs fetched countries

## Run The Application

1. Make sure MySQL is running and `ormlearn.country` table has data.
2. Run `OrmLearnApplication` as a Java Application.
3. Check logs for:
   - `Inside main`
   - `countries=[...]`
