package com.example.fitnesscenter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    @NotBlank(message = "Plan name is required")
    private String planName;

    @NotBlank(message = "Membership type is required")
    private String membershipType;

    @Min(value = 1, message = "Access hours must be greater than 0")
    private int monthlyAccessHours;

    private LocalDate launchDate;

    private LocalDate expirationDate;

    @Positive(message = "Monthly fee must be positive")
    private double monthlyFee;

    @NotBlank(message = "Benefits required")
    private String benefits;

    private boolean dietPlanOpted;
}