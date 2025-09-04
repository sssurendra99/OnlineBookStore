package com.bookstore.user.dtos;

public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    
    public AuthResponse() { }
    
    // Constructor that accepts only access token (for backward compatibility)
    public AuthResponse(String accessToken) { 
        this.accessToken = accessToken; 
    }
    
    // Constructor that accepts both access token and refresh token
    public AuthResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    
    // Getters and Setters
    public String getAccessToken() { 
        return accessToken; 
    }
    
    public void setAccessToken(String accessToken) { 
        this.accessToken = accessToken; 
    }
    
    public String getRefreshToken() { 
        return refreshToken; 
    }
    
    public void setRefreshToken(String refreshToken) { 
        this.refreshToken = refreshToken; 
    }
    
    public String getTokenType() { 
        return tokenType; 
    }
    
    public void setTokenType(String tokenType) { 
        this.tokenType = tokenType; 
    }
    
    // Backward compatibility - keep this for existing code that might use getToken()
    @Deprecated
    public String getToken() { 
        return accessToken; 
    }
    
    @Deprecated
    public void setToken(String token) { 
        this.accessToken = token; 
    }
}