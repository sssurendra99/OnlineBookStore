package com.bookstore.user.service;

import com.bookstore.user.model.RefreshToken;
import com.bookstore.user.model.User;
import com.bookstore.user.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    
    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenDurationMs;
    
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService; // Added JwtService dependency

    public RefreshToken createRefreshToken(User user) {
        // Delete existing refresh tokens for the user
        deleteByUser(user);
        
        RefreshToken refreshToken = RefreshToken.builder()
            .user(user)
            .expiryDate(Instant.now().plusMillis(refreshTokenDurationMs))
            .token(UUID.randomUUID().toString())
            .build();
        
        return refreshTokenRepository.save(refreshToken);
    }

    public boolean isTokenExpired(RefreshToken token) {
        return token.getExpiryDate().isBefore(Instant.now());
    }

    public void deleteByUser(User user) {
        refreshTokenRepository.deleteByUser(user);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    // Fixed method: should return new access token, not create refresh token
    public String refreshAccessToken(String refreshTokenString) {
        RefreshToken refreshToken = findByToken(refreshTokenString)
            .orElseThrow(() -> new RuntimeException("Refresh token not found"));

        if (isTokenExpired(refreshToken)) {
            refreshTokenRepository.delete(refreshToken);
            throw new RuntimeException("Refresh token expired");
        }

        // Generate new access token
        return jwtService.generateToken(refreshToken.getUser().getUsername());
    }
}