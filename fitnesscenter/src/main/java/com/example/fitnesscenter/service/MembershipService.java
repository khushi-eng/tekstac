package com.example.fitnesscenter.service;

import com.example.fitnesscenter.entity.Membership;

import java.util.List;
import java.util.Map;

public interface MembershipService {

    Membership addMembership(Membership membership);

    Membership getMembershipById(Long id);

    List<Membership> getByBenefits(String benefits);

    List<Membership> getByTypeAndHours(String type, int hours);

    Map<String, Long> getMembershipCountByType();
}