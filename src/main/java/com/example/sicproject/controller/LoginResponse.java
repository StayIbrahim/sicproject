package com.example.sicproject.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private Long id;
    private String username;
    private String token;

    public LoginResponse(Long id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    // Getters
}