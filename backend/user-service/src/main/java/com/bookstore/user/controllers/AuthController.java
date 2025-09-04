package com.bookstore.user.controllers;

import com.bookstore.user.dtos.*;
import com.bookstore.user.model.User;
import com.bookstore.user.service.RefreshTokenService;
import com.bookstore.user.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "User Service", description = "APIs for managing users")
public class AuthController {
    
    private final UserService users;
    private final RefreshTokenService refreshTokens;

    public AuthController(UserService users, RefreshTokenService refreshTokens) {
        this.users = users;
        this.refreshTokens = refreshTokens;
    }

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        try {
            User u = users.register(req);
            return ResponseEntity.ok("Registered user: " + u.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login endpoint with JWT + refresh token
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        try {
            AuthResponse authResp = users.loginWithRefresh(req);
            return ResponseEntity.ok(authResp);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }

    // Refresh access token endpoint - FIXED METHOD CALL
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        try {
            String newAccessToken = refreshTokens.refreshAccessToken(request.getRefreshToken());
            return ResponseEntity.ok(new TokenRefreshResponse(newAccessToken));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}