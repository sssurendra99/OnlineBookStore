package com.bookstore.user.dtos;

import jakarta.validation.constraints.NotBlank;

public class TokenRefreshRequest {
    
    @NotBlank(message = "Refresh token is required")
    private String refreshToken;
    
    public TokenRefreshRequest() { }
    
    public TokenRefreshRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    
    public String getRefreshToken() {
        return refreshToken;
    }
    
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}