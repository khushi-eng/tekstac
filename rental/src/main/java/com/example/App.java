package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.RentalCarBooking;

public class App {

    public static void main(String[] args) {

        ApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);

        RentalCarBooking booking = context.getBean(RentalCarBooking.class);

        booking.checkStatus();

        System.out.println();

        booking.bookCar();

        System.out.println();

        booking.checkStatus();

        System.out.println();

        try {
            booking.bookCar();
        } catch (Exception e) {

        }

        System.out.println();

        booking.releaseCar();

        System.out.println();

        try {
            booking.releaseCar();
        } catch (Exception e) {

        }
    }
}