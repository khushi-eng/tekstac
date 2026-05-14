package com.example.fitnesscenter.controller;

import com.example.fitnesscenter.entity.Membership;
import com.example.fitnesscenter.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    private final MembershipService service;

    public MembershipController(MembershipService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Membership> addMembership(
            @Valid @RequestBody Membership membership) {

        return new ResponseEntity<>(
                service.addMembership(membership),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long id) {

        return ResponseEntity.ok(service.getMembershipById(id));
    }

    @GetMapping("/benefits/{benefits}")
    public ResponseEntity<List<Membership>> getByBenefits(
            @PathVariable String benefits) {

        return ResponseEntity.ok(service.getByBenefits(benefits));
    }

    @GetMapping("/type/{type}/hours/{hours}")
    public ResponseEntity<List<Membership>> getByTypeAndHours(
            @PathVariable String type,
            @PathVariable int hours) {

        return ResponseEntity.ok(
                service.getByTypeAndHours(type, hours)
        );
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getCountByType() {

        return ResponseEntity.ok(
                service.getMembershipCountByType()
        );
    }
}