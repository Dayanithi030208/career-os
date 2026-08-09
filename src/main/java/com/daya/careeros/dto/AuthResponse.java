package com.daya.careeros.dto;

import java.util.UUID;

public class AuthResponse {

    private UUID id;
    private String name;
    private String email;
    private String token;

    public AuthResponse(UUID id, String name, String email) {
        this(id, name, email, null);
    }

    public AuthResponse(
            UUID id,
            String name,
            String email,
            String token
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}