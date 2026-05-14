package com.example.repository;

import com.example.model.ATMCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATMCardRepository extends JpaRepository<ATMCard, Long> {
}