package com.daya.careeros.dto;

import java.util.UUID;

public class CareerProfileResponse {

    private UUID id;
    private String targetRole;
    private String currentLevel;
    private String careerGoal;

    public CareerProfileResponse(
            UUID id,
            String targetRole,
            String currentLevel,
            String careerGoal
    ) {
        this.id = id;
        this.targetRole = targetRole;
        this.currentLevel = currentLevel;
        this.careerGoal = careerGoal;
    }

    public UUID getId() {
        return id;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getCareerGoal() {
        return careerGoal;
    }
}