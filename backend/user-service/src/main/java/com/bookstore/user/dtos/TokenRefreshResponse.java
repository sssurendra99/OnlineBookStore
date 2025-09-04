package com.bookstore.user.dtos;

public class TokenRefreshResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    
    public TokenRefreshResponse() { }
    
    public TokenRefreshResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public TokenRefreshResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
    
    // Getters and Setters
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getTokenType() {
        return tokenType;
    }
    
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}