package com.cognizant.springlearn.model;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Employee {

    private int id;

    @NotBlank(message = "Employee name cannot be blank")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Department is required")
    private Department department;

    private List<Skill> skills;

    public Employee() {
    }

    public Employee(int id, String name, String email,
                    Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}