package com.telerikacademy.hibernatedemo.data;

import com.telerikacademy.hibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getByID(int id);

    List<Employee> getAll();
}
