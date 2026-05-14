package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookingAspect {

    @Around("execution(* com.example.service.RentalCarBooking.bookCar(..))")
    public Object aroundBooking(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Checking availability before booking...");

        Object obj = joinPoint.proceed();

        System.out.println("Booking completed.");

        return obj;
    }

    @AfterReturning("execution(* com.example.service.RentalCarBooking.releaseCar(..))")
    public void afterReturningRelease() {

        System.out.println("Release operation logged.");
    }

    @After("execution(* com.example.service.RentalCarBooking.releaseCar(..))")
    public void afterRelease() {

        System.out.println("Thank you for using our rental service.");
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.service.RentalCarBooking.*(..))",
            throwing = "ex")
    public void handleException(Exception ex) {

        System.out.println("Exception: " + ex.getMessage());
    }
}