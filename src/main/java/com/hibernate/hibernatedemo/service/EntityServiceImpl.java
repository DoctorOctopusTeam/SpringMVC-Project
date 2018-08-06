package com.hibernate.hibernatedemo.service;

import com.hibernate.hibernatedemo.data.EntityRepository;
import com.hibernate.hibernatedemo.models.Employee;
import com.hibernate.hibernatedemo.models.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class EntityServiceImpl implements EntityService {

    private EntityRepository entRepo;

    @Autowired
    public EntityServiceImpl(EntityRepository entRepo){
        this.entRepo = entRepo;
    }

    @Override
    public Double showAverageSalary() {
        return entRepo.showAverageSalary();
    }

    @Override
    public List<Employee> listAllEmployees() {
        return entRepo.listAllEmployees();
    }

    @Override
    public List<Town> listAllTowns() {
        return entRepo.listAllTowns();
    }

    @Override
    public List<Employee> listAllFromDepartment(String depName) {
        return entRepo.listAllFromDepartment(depName);
    }

    @Override
    public void createNewTown(String townName) {
        entRepo.createNewTown(townName);
    }

    @Override
    public String deleteTown(int id) {
        return entRepo.deleteTown(id);
    }
}
