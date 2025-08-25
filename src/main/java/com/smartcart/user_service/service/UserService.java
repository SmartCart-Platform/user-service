package com.smartcart.user_service.service;


import com.smartcart.user_service.dto.UserDto;

public interface UserService {
    UserDto getUserByUsername(String username);
}