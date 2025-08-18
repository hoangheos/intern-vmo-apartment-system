package com.example.apartment.dto;

public class AuthDtos {
    public record LoginRequest(String username, String password) {}
    public record LoginResponse(String token) {}
    public record RegisterRequest(String username, String password, String email) {}
}
