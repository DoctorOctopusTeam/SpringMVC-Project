package com.hibernate.hibernatedemo.data;

import com.hibernate.hibernatedemo.models.Employee;
import com.hibernate.hibernatedemo.models.Town;

import java.util.List;

public interface EntityRepository {

    Double showAverageSalary();

    List<Employee> listAllEmployees();

    List<Town> listAllTowns();

    List<Employee> listAllFromDepartment(String depName);

    void createNewTown(String townName);

    String deleteTown(int id);
}
