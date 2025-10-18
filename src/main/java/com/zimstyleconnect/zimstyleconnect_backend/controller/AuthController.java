package com.zimstyleconnect.zimstyleconnect_backend.controller;

import com.zimstyleconnect.zimstyleconnect_backend.dto.AuthResponse;
import com.zimstyleconnect.zimstyleconnect_backend.dto.LoginRequest;
import com.zimstyleconnect.zimstyleconnect_backend.dto.RegisterRequest;
import com.zimstyleconnect.zimstyleconnect_backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")  // qBase route for authentication endpoints
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Handles user registration.
     * @param request Contains fullName, email, password
     * @return JWT token in AuthResponse
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Handles user login authentication.
     * @param request Contains email and password
     * @return JWT token if authentication succeeds
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
