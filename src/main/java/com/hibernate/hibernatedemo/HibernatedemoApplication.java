package com.hibernate.hibernatedemo;

import com.hibernate.hibernatedemo.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatedemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(HibernatedemoApplication.class, args);
    }
}
