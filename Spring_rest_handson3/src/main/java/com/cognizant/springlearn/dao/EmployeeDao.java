package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> employees = context.getBean("employeeList", List.class);
        context.close();
        LOGGER.info("END");
        return employees;
    }

    public Employee getEmployee(int id) {
        LOGGER.info("START");
        Employee employee = getAllEmployees().stream()
            .filter(e -> e.getId() == id)
            .findFirst()
            .orElse(null);
        LOGGER.info("END");
        return employee;
    }
}
