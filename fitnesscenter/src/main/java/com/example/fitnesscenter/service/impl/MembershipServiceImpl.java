package com.example.fitnesscenter.service.impl;

import com.example.fitnesscenter.entity.Membership;
import com.example.fitnesscenter.exception.MembershipNotFoundException;
import com.example.fitnesscenter.repository.MembershipRepository;
import com.example.fitnesscenter.service.MembershipService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository repository;

    public MembershipServiceImpl(MembershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public Membership addMembership(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public Membership getMembershipById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new MembershipNotFoundException("Membership not found with id " + id));
    }

    @Override
    public List<Membership> getByBenefits(String benefits) {
        return repository.findByBenefits(benefits);
    }

    @Override
    public List<Membership> getByTypeAndHours(String type, int hours) {
        return repository
                .findByMembershipTypeAndMonthlyAccessHoursGreaterThan(type, hours);
    }

    @Override
    public Map<String, Long> getMembershipCountByType() {

        List<Membership> memberships = repository.findAll();

        Map<String, Long> map = new HashMap<>();

        for (Membership m : memberships) {
            map.put(
                    m.getMembershipType(),
                    map.getOrDefault(m.getMembershipType(), 0L) + 1
            );
        }

        return map;
    }
}