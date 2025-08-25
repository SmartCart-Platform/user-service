package com.smartcart.user_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ERole {
    ADMINISTRATOR("Administrator"),
    EMPLOYEE("Employee"),
    CUSTOMER("Customer");

    private final String label;
}