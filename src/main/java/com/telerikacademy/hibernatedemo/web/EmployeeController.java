package com.telerikacademy.hibernatedemo.web;

import com.telerikacademy.hibernatedemo.models.Employee;
import com.telerikacademy.hibernatedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(){

    }
    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @RequestMapping("/{id}")
    public Employee findByID(@PathVariable("id") String stringID){
        return service.getByID(Integer.parseInt(stringID));
    }

    @RequestMapping("/")
    public List<Employee> listAll(){
        return service.getAll();
    }


}
