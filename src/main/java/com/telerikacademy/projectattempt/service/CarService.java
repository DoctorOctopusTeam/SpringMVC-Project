package com.telerikacademy.projectattempt.service;

import com.telerikacademy.projectattempt.models.Car;

import java.util.List;

public interface CarService {
    public void addCar(Car car);

    public List<Car> listAll();

    public Double getAverage(Car car);
}
