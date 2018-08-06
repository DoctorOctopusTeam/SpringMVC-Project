package com.hibernate.hibernatedemo.data;

import com.hibernate.hibernatedemo.models.Employee;
import com.hibernate.hibernatedemo.models.Town;
import com.hibernate.hibernatedemo.service.EntityService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityRepositoryImpl implements EntityService {


    @Override
    public Double showAverageSalary() {
        return null;
    }

    @Override
    public List<Employee> listAllEmployees() {
        return null;
    }

    @Override
    public List<Town> listAllTowns() {
        return null;
    }

    @Override
    public List<Employee> listAllFromDepartment(String depName) {
        return null;
    }

    @Override
    public void createNewTown(String townName) {

    }

    @Override
    public String deleteTown(int id) {
        return null;
    }
}
