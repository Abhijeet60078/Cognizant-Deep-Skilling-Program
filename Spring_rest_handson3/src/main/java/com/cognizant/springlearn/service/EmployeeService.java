package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        List<Employee> employees = employeeDao.getAllEmployees();
        LOGGER.debug("employees={}", employees);
        LOGGER.info("END");
        return employees;
    }

    public Employee getEmployee(int id) {
        LOGGER.info("START");
        Employee employee = employeeDao.getEmployee(id);
        LOGGER.debug("employee={}", employee);
        LOGGER.info("END");
        return employee;
    }
}
