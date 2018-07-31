package com.telerikacademy.hibernatedemo.service;

import com.telerikacademy.hibernatedemo.data.EmployeeRepository;
import com.telerikacademy.hibernatedemo.data.EmployeeSQLRepository;
import com.telerikacademy.hibernatedemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeSQLRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeSQLRepository repository){
        this.repository = repository;
    }
    @Override
    public Employee getByID(int id) {
        return repository.getByID(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }
}
