package com.telerikacademy.hibernatedemo.data;

import com.telerikacademy.hibernatedemo.models.Address;
import com.telerikacademy.hibernatedemo.models.Employee;
import com.telerikacademy.hibernatedemo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeSQLRepository implements EmployeeRepository {
    private static final SessionFactory factory;

   static{
       factory = new Configuration()
               .configure("hibernate.cfg.xml")
               .addAnnotatedClass(Employee.class)
               .addAnnotatedClass(Town.class)
               .addAnnotatedClass(Address.class)
               .buildSessionFactory();
   }

    @Override
    public Employee getByID(int id) {
        Employee e = null;
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            e = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return e;
    }

    @Override
    public List<Employee> getAll() {
       List<Employee> employees = new ArrayList<>();
       try(Session session = factory.openSession()){
            session.beginTransaction();
            employees = session.createQuery("from Employee").list();
            session.getTransaction().commit();
       } catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return employees;
    }
}
