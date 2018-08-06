package com.hibernate.hibernatedemo.service;

import com.hibernate.hibernatedemo.data.EntityRepository;
import com.hibernate.hibernatedemo.models.Employee;
import com.hibernate.hibernatedemo.models.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityServiceImpl implements EntityService {

    private EntityRepository entRepo;

    @Autowired
    public EntityServiceImpl(EntityRepository entRepo){
        this.entRepo = entRepo;
    }

    public EntityRepository getEntRepo() {
        return entRepo;
    }

    public void setEntRepo(EntityRepository entRepo) {
        this.entRepo = entRepo;
    }

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
