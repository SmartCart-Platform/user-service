package com.smartcart.user_service.service.impl;


import com.smartcart.user_service.dto.UserDto;
import com.smartcart.user_service.entity.UserCredential;
import com.smartcart.user_service.repository.UserCredentialRepository;
import com.smartcart.user_service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserCredentialRepository userCredentialRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserCredentialRepository userCredentialRepository, ModelMapper modelMapper) {
        this.userCredentialRepository = userCredentialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        UserCredential userCredential = userCredentialRepository.findByName(username).orElse(null);
        if(userCredential != null){
            System.out.println("UserCredential: " + userCredential);
            return modelMapper.map(userCredential, UserDto.class);
        }
        return null;
    }
}