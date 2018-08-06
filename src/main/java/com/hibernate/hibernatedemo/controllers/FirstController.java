package com.hibernate.hibernatedemo.controllers;

import com.hibernate.hibernatedemo.models.*;
import com.hibernate.hibernatedemo.service.EntityService;
import javafx.scene.control.Alert;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;

@RestController
public class FirstController {
    private EntityService entService;

    @Autowired
    public FirstController(EntityService entService){
        this.entService = entService;
    }

    SessionFactory f = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Project.class)
            .addAnnotatedClass(Town.class)
            .buildSessionFactory();

    @RequestMapping("/averagesalary")
    public Double showAverageSalary(){
        return entService.showAverageSalary();
    }

    @RequestMapping("/allemployees")
    public List<Employee> listAllEmployees(){
        return entService.listAllEmployees();
    }
    @RequestMapping("/alltowns")
    public List<Town> listAllTowns(){
        return entService.listAllTowns();
    }

    @RequestMapping("/allemployeesfromdepartment")
    public List<Employee> listAllFromDepartment(String depName){
        return entService.listAllFromDepartment(depName);
    }

    @RequestMapping(value = "/newtown", method = RequestMethod.POST)
    public void createNewTown(String townName){
        entService.createNewTown(townName);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTown(int id){
        return entService.deleteTown(id);
    }



}
