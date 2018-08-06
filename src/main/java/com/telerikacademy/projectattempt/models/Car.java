package com.telerikacademy.projectattempt.models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "fuel")
    private String fuel;

    @Column(name = "consume")
    private double consumeFuel;

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car(int id, String make, String model, String fuel, double consumeFuel) {
        this.id = id;

        this.make = make;
        this.model = model;
        this.fuel = fuel;
        this.consumeFuel = consumeFuel;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getConsumeFuel() {
        return consumeFuel;
    }

    public void setConsumeFuel(double consumeFuel) {
        this.consumeFuel = consumeFuel;
    }
}

