package com.hibernate.hibernatedemo.service;

import com.hibernate.hibernatedemo.models.Employee;
import com.hibernate.hibernatedemo.models.Town;

import java.util.List;

public interface EntityService {

    Double showAverageSalary();

    List<Employee> listAllEmployees();

    List<Town> listAllTowns();

    List<Employee> listAllFromDepartment(String depName);

    void createNewTown(String townName);

    String deleteTown(int id);

}
