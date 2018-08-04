package com.telerikacademy.projectattempt.data;

import com.telerikacademy.projectattempt.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
    }

    @Override
    public void addCar(Car car) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Car> listAll() {
        List<Car> cars = new ArrayList<>();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            cars = session.createQuery("FROM Car").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    //gets the average consume, but only print it in console -> there is no get method to display in html
    @Override
    public Double getAverage(Car car) {
        Double c = 0.0;

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select avg(consumeFuel) from Car carr where carr.make = :make").setProperties(car);
            c = (Double) query.uniqueResult();
            System.out.println(c);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}

