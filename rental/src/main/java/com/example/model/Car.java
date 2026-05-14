package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private String model = "Toyota Fortuner";
    private boolean booked = false;

    public String getModel() {
        return model;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void displayStatus() {

        if (booked) {
            System.out.println(model + " is booked.");
        } else {
            System.out.println(model + " is available.");
        }
    }
}