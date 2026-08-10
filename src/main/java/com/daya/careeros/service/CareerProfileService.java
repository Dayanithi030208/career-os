package com.daya.careeros.service;

import com.daya.careeros.dto.CareerProfileRequest;
import com.daya.careeros.entity.CareerProfile;
import com.daya.careeros.entity.User;
import com.daya.careeros.repository.CareerProfileRepository;
import com.daya.careeros.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.daya.careeros.exception.ConflictException;

import java.util.UUID;

@Service
public class CareerProfileService {

    private final CareerProfileRepository careerProfileRepository;
    private final UserRepository userRepository;

    public CareerProfileService(
            CareerProfileRepository careerProfileRepository,
            UserRepository userRepository
    ) {
        this.careerProfileRepository = careerProfileRepository;
        this.userRepository = userRepository;
    }

    public CareerProfile getByUserId(UUID userId) {

        return careerProfileRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Career profile not found"
                        )
                );
    }

    public CareerProfile createProfile(
            UUID userId,
            CareerProfileRequest request
    ) {

        if (careerProfileRepository.findByUserId(userId).isPresent()) {
            throw new ConflictException(
                    "Career profile already exists"
            );
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found"
                        )
                );

        CareerProfile profile = new CareerProfile();

        profile.setUser(user);
        profile.setTargetRole(request.getTargetRole());
        profile.setCurrentLevel(request.getCurrentLevel());
        profile.setCareerGoal(request.getCareerGoal());

        return careerProfileRepository.save(profile);
    }
}