package com.smartcart.user_service.entity.converter;

import com.smartcart.user_service.enums.ERole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<ERole, String> {

    @Override
    public String convertToDatabaseColumn(ERole status) {
        if(status == null){
            return null;
        }
        return status.getLabel();
    }

    @Override
    public ERole convertToEntityAttribute(String label) {
        if(label == null){
            return null;
        }
        return switch(label) {
            case "Administrator" -> ERole.ADMINISTRATOR;
            case "Employee" -> ERole.EMPLOYEE;
            case "Customer" -> ERole.CUSTOMER;
            default -> throw new IllegalArgumentException("Unknown role: " + label);
        };
    }
}