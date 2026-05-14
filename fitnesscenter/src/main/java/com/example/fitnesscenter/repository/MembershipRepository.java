package com.example.fitnesscenter.repository;

import com.example.fitnesscenter.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    List<Membership> findByBenefits(String benefits);

    List<Membership> findByMembershipTypeAndMonthlyAccessHoursGreaterThan(
            String membershipType,
            int monthlyAccessHours
    );
}