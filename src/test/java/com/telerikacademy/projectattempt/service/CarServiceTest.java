package com.telerikacademy.projectattempt.service;

import com.telerikacademy.projectattempt.data.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    CarRepository mockRepository;

    @InjectMocks
    CarServiceImpl carService;


}
