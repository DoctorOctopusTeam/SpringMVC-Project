package com.telerikacademy.projectattempt.service;

import com.telerikacademy.projectattempt.data.CarRepository;
import com.telerikacademy.projectattempt.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public List<Car> listAll(){
        return carRepository.listAll();
    }

    @Override
    public int getAverage(Car car) {
        return carRepository.getAverage(car);
    }
}
