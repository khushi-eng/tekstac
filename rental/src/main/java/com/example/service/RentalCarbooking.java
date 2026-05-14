package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Car;

@Component
public class RentalCarBooking {

    @Autowired
    private Car car;

    public void bookCar() {

        if (car.isBooked()) {
            throw new RuntimeException("Car is already booked!");
        }

        car.setBooked(true);

        System.out.println("Car booked successfully: " + car.getModel());
    }

    public void releaseCar() {

        if (!car.isBooked()) {
            throw new RuntimeException("Car is not booked!");
        }

        car.setBooked(false);

        System.out.println("Car released successfully: " + car.getModel());
    }

    public void checkStatus() {
        car.displayStatus();
    }
}