package com.telerikacademy.projectattempt.web;

import com.telerikacademy.projectattempt.models.Car;
import com.telerikacademy.projectattempt.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController( CarService carService){
        this.carService = carService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Car> listAll(){
        return carService.listAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Double getAverage(@RequestBody Car car){
        return carService.getAverage(car);
    }
}

