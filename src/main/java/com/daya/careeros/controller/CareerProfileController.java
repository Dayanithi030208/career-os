package com.daya.careeros.controller;

import com.daya.careeros.dto.CareerProfileRequest;
import com.daya.careeros.dto.CareerProfileResponse;
import com.daya.careeros.entity.CareerProfile;
import com.daya.careeros.service.CareerProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
public class CareerProfileController {

    private final CareerProfileService careerProfileService;

    public CareerProfileController(
            CareerProfileService careerProfileService
    ) {
        this.careerProfileService = careerProfileService;
    }

    @GetMapping
    public CareerProfileResponse getProfile(
            Authentication authentication
    ) {

        UUID userId = (UUID) authentication.getPrincipal();

        CareerProfile profile =
                careerProfileService.getByUserId(userId);

        return new CareerProfileResponse(
                profile.getId(),
                profile.getTargetRole(),
                profile.getCurrentLevel(),
                profile.getCareerGoal()
        );
    }

    @PostMapping
    public ResponseEntity<CareerProfileResponse> createProfile(
            Authentication authentication,
            @Valid @RequestBody CareerProfileRequest request
    ) {

        UUID userId = (UUID) authentication.getPrincipal();

        CareerProfile profile =
                careerProfileService.createProfile(userId, request);

        CareerProfileResponse response = new CareerProfileResponse(
                profile.getId(),
                profile.getTargetRole(),
                profile.getCurrentLevel(),
                profile.getCareerGoal()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}