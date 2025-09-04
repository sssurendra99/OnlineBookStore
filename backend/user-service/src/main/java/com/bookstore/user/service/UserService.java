package com.bookstore.user.service;

import com.bookstore.user.dtos.AuthResponse;
import com.bookstore.user.dtos.LoginRequest;
import com.bookstore.user.dtos.RegisterRequest;
import com.bookstore.user.model.RefreshToken;
import com.bookstore.user.model.Role;
import com.bookstore.user.model.User;
import com.bookstore.user.repository.RoleRepository;
import com.bookstore.user.repository.UserRepository;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final UserRepository users;
    private final RoleRepository roles;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService; // Added missing dependency

    public UserService(UserRepository users,
                      RoleRepository roles,
                      PasswordEncoder passwordEncoder,
                      AuthenticationManager authManager,
                      JwtService jwtService,
                      RefreshTokenService refreshTokenService) { // Added parameter
        this.users = users;
        this.roles = roles;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService; // Initialize field
    }

    public void ensureDefaultRoleExists() {
        roles.findByName("USER").orElseGet(() -> {
            Role r = new Role();
            r.setName("USER");
            return roles.save(r);
        });
    }

    public User register(RegisterRequest req) {
        if (users.existsByUsername(req.getUsername()))
            throw new IllegalArgumentException("Username already taken");
        if (users.existsByEmail(req.getEmail()))
            throw new IllegalArgumentException("Email already in use");

        ensureDefaultRoleExists();
        Role userRole = roles.findByName("USER").orElseThrow();

        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setRoles(Set.of(userRole));
        return users.save(u);
    }

    public String login(LoginRequest req) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getUsernameOrEmail(), req.getPassword())
        );
        String principal = auth.getName(); // username
        return jwtService.generateToken(principal);
    }

    public Optional<User> findByUsername(String username) {
        return users.findByUsername(username);
    }

    public AuthResponse loginWithRefresh(LoginRequest req) {
        // Use Spring Security's AuthenticationManager for consistent authentication
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getUsernameOrEmail(), req.getPassword())
        );
        
        String username = auth.getName();
        User user = users.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Generate access token using username (String)
        String accessToken = jwtService.generateToken(username);
        
        // Generate refresh token
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
        
        return new AuthResponse(accessToken, refreshToken.getToken());
    }
}