package com.hibernate.hibernatedemo.data;

import com.hibernate.hibernatedemo.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class EntityRepositoryImpl implements EntityRepository {

    private SessionFactory sessionFactory;

    public EntityRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    @Override
    public Double showAverageSalary() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<Double> avg = s.createQuery("select salary from Employee").list();
        Double avgSalary = 0D;
        for (int i = 0; i < avg.size(); i++){
            avgSalary += avg.get(i);
        }
        avgSalary /= avg.size();
        s.getTransaction().commit();
        //s.close();
        return avgSalary;
    }

    @Override
    public List<Employee> listAllEmployees() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<Employee> list = s.createQuery("from Employee").list();
        s.getTransaction().commit();
        //s.close();
        return list;
    }

    @Override
    public List<Town> listAllTowns() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<Town> list = s.createQuery("from Town").list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @Override
    public List<Employee> listAllFromDepartment(String depName) {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<Employee> list = s.createQuery("from Employee where department.name = :str").setParameter("str", depName).list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @Override
    public void createNewTown(String townName) {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        Town newTown = new Town(townName);
        s.save(newTown);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public String deleteTown(int id) {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        Town t = s.get(Town.class, id);
        s.delete(t);
        s.getTransaction().commit();
        s.close();
        return t.getName();
    }
}
