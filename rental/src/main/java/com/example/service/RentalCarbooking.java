package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Car;

@Component
public class RentalCarBooking {

    @Autowired
    private List<Car> cars;

    public void bookCar() {

        Car car = cars.get(0);

        if (car.isBooked()) {
            throw new RuntimeException("Car already booked!");
        }

        car.setBooked(true);

        System.out.println("Car booked successfully: " + car.getModel());
    }

    public void releaseCar() {

        Car car = cars.get(0);

        if (!car.isBooked()) {
            throw new RuntimeException("Car is not booked!");
        }

        car.setBooked(false);

        System.out.println("Car released successfully: " + car.getModel());
    }

    public void checkStatus() {

        Car car = cars.get(0);

        car.displayStatus();
    }
}