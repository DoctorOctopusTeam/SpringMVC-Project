package com.hibernate.hibernatedemo.controllers;

import com.hibernate.hibernatedemo.models.*;
import com.hibernate.hibernatedemo.service.EntityService;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FirstController {
    private EntityService entService;

    public FirstController(EntityService entService){
        this.entService = entService;
    }

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
