package com.telerikacademy.projectattempt.data;

import com.telerikacademy.projectattempt.models.Car;

import java.util.List;

public interface CarRepository {
    public void addCar(Car car);

    public List<Car> listAll();

    public Double getAverage(Car car);
}
