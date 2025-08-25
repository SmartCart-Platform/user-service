package com.smartcart.user_service.config;

import com.smartcart.user_service.dto.RoleDto;
import com.smartcart.user_service.dto.UserDto;
import com.smartcart.user_service.entity.Role;
import com.smartcart.user_service.entity.UserCredential;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from Role to RoleDto
        modelMapper.typeMap(Role.class, RoleDto.class)
                .addMappings(mapper -> mapper.map(Role::getName, RoleDto::setAuthority));

        // Mapping from UserCredential to UserDto
        modelMapper.typeMap(UserCredential.class, UserDto.class)
                .addMappings(mapper -> mapper.skip(UserDto::setRoles))
                .setPostConverter(context -> {
                    UserCredential source = context.getSource();
                    UserDto destination = context.getDestination();

                    Set<RoleDto> roleDtos = source.getRoles().stream()
                            .map(role -> modelMapper.map(role, RoleDto.class))
                            .collect(Collectors.toSet());
                    destination.setRoles(roleDtos);
                    return destination;
                });

        return modelMapper;
    }
}