package com.saru.service;

import com.saru.dto.UserRegisterDto;
import com.saru.model.User;
import com.saru.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public void saveUser(UserRegisterDto userRegisterDto) {
        userRepository.save( User.builder()
                .userName(userRegisterDto.getUserName())
                .password(userRegisterDto.getPassword())
                .email(userRegisterDto.getEmail())
                .firstName(userRegisterDto.getFirstName())
                .lastName(userRegisterDto.getLastName())
                .phoneNumber(userRegisterDto.getPhoneNumber())
                .build());
    }
}
