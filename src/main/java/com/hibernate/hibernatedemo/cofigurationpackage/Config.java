package com.hibernate.hibernatedemo.cofigurationpackage;

import com.hibernate.hibernatedemo.data.EntityRepository;
import com.hibernate.hibernatedemo.data.EntityRepositoryImpl;
import com.hibernate.hibernatedemo.models.*;
import com.hibernate.hibernatedemo.service.EntityService;
import com.hibernate.hibernatedemo.service.EntityServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SessionFactory createSessFak() {
        return new org.hibernate.cfg.Configuration()
                .configure("static/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Town.class)
                .buildSessionFactory();
    }

    @Bean
    public EntityRepository createEntityRepository(SessionFactory sessionFactory){
        return new EntityRepositoryImpl(sessionFactory);
    }

    @Bean
    public EntityService createEntityService(EntityRepository entityRepository){
        return new EntityServiceImpl(entityRepository);
    }







}
