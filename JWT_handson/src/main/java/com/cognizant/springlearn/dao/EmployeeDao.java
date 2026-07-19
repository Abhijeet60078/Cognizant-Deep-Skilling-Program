package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;

@Repository
public class EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    static {

        Department d1 = new Department(1, "Engineering");
        Department d2 = new Department(2, "Human Resource");

        Skill s1 = new Skill(1, "Java");
        Skill s2 = new Skill(2, "Spring Boot");
        Skill s3 = new Skill(3, "SQL");
        Skill s4 = new Skill(4, "React");

        employeeList.add(
                new Employee(
                        101,
                        "Abhijeet Mishra",
                        "abhijeet@gmail.com",
                        d1,
                        Arrays.asList(s1, s2, s3)));

        employeeList.add(
                new Employee(
                        102,
                        "Rahul Sharma",
                        "rahul@gmail.com",
                        d2,
                        Arrays.asList(s3, s4)));

    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {

        for (Employee employee : employeeList) {

            if (employee.getId() == id) {
                return employee;
            }

        }

        return null;

    }

    public Employee addEmployee(Employee employee) {

        employeeList.add(employee);

        return employee;

    }

    public Employee updateEmployee(int id, Employee employee) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId() == id) {

                employeeList.set(i, employee);

                return employee;

            }

        }

        return null;

    }

    public boolean deleteEmployee(int id) {

        return employeeList.removeIf(employee -> employee.getId() == id);

    }

}