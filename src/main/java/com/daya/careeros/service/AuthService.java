package com.daya.careeros.service;

import com.daya.careeros.dto.AuthResponse;
import com.daya.careeros.dto.LoginRequest;
import com.daya.careeros.dto.RegisterRequest;
import com.daya.careeros.entity.User;
import com.daya.careeros.exception.DuplicateEmailException;
import com.daya.careeros.exception.InvalidCredentialsException;
import com.daya.careeros.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.daya.careeros.dto.UserResponse;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already registered");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        return new AuthResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"
                        )
                );

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new InvalidCredentialsException(
                    "Invalid email or password"
            );
        }

        String token = jwtService.generateToken(
                user.getId(),
                user.getEmail()
        );

        return new AuthResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                token
        );
    }
    public UserResponse getCurrentUser(UUID userId) {

    User user = userRepository.findById(userId)
            .orElseThrow(() ->
                    new IllegalArgumentException("User not found")
            );

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        }
}