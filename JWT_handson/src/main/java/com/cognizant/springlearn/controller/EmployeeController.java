package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
public Employee getEmployee(@PathVariable int id) {

    Employee employee = employeeService.getEmployee(id);

    if (employee == null) {
        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " not found");
    }

    return employee;
}
    // POST Employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

        Employee savedEmployee = employeeService.addEmployee(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
public Employee updateEmployee(
        @PathVariable int id,
        @Valid @RequestBody Employee employee) {

    Employee updatedEmployee =
            employeeService.updateEmployee(id, employee);

    if (updatedEmployee == null) {

        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " not found");

    }

    return updatedEmployee;
}
    @DeleteMapping("/{id}")
public String deleteEmployee(@PathVariable int id) {

    boolean deleted = employeeService.deleteEmployee(id);

    if (!deleted) {

        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " not found");

    }

    return "Employee deleted successfully";
}
}