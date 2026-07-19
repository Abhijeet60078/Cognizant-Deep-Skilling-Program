package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {

        employee.setId(id);

        return employeeDao.updateEmployee(id, employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }

}