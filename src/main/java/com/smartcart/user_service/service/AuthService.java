package com.smartcart.user_service.service;

import com.smartcart.user_service.dto.AuthRequest;
import com.smartcart.user_service.dto.SignUpRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    String saveUser(SignUpRequest userCredential);
    String generateToken(AuthRequest authRequest, HttpServletResponse response);
    void validateToken(String token);
}