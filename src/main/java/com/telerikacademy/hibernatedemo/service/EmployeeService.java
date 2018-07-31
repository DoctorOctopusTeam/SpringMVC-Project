package com.telerikacademy.hibernatedemo.service;

import com.telerikacademy.hibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getByID(int id);

    List<Employee> getAll();

}
