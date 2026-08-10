package com.daya.careeros.controller;

import com.daya.careeros.dto.UserResponse;
import com.daya.careeros.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/me")
    public UserResponse getCurrentUser(Authentication authentication) {

        return authService.getCurrentUser(
                (java.util.UUID) authentication.getPrincipal()
        );
    }
}