package com.hibernate.hibernatedemo.controllers;

import com.hibernate.hibernatedemo.models.*;
import javafx.scene.control.Alert;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;

@RestController
public class FirstController {

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
       Session s = f.openSession();
       s.beginTransaction();
       List<Double> avg = s.createQuery("select salary from Employee").list();
       Double avgSalary = 0D;
       for (int i = 0; i < avg.size(); i++){
           avgSalary += avg.get(i);
       }
       avgSalary /= avg.size();
       s.getTransaction().commit();
       s.close();
       return avgSalary;
    }

    @RequestMapping("/allemployees")
    public List<Employee> listAllEmployees(){
        Session s = f.openSession();
        s.beginTransaction();
        List<Employee> list = s.createQuery("from Employee").list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    @RequestMapping("/alltowns")
    public List<Town> listAllTowns(){
        Session s = f.openSession();
        s.beginTransaction();
        List<Town> list = s.createQuery("from Town").list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @RequestMapping("/allemployeesfromdepartment")
    public List<Employee> listAllFromDepartment(String depName){
        Session s = f.openSession();
        s.beginTransaction();
        List<Employee> list = s.createQuery("from Employee where department.name = :str").setParameter("str", depName).list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @RequestMapping(value = "/newtown", method = RequestMethod.POST)
    public void createNewTown(String townName){
        Session s = f.openSession();
        s.beginTransaction();
        Town newTown = new Town(townName);
        s.save(newTown);
        s.getTransaction().commit();
        s.close();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTown(int id){
        Session s = f.openSession();
        s.beginTransaction();
        Town t = s.get(Town.class, id);
        s.delete(t);
        s.getTransaction().commit();
        s.close();
        return t.getName();
    }



}
