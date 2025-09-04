package com.bookstore.user.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public LoginRequest() { }

    public String getUsernameOrEmail() { return usernameOrEmail; }
    public String getPassword() { return password; }

    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }
    public void setPassword(String password) { this.password = password; }
}
