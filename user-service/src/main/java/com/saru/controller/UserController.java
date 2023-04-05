package com.saru.controller;

import com.saru.dto.UserRegisterDto;
import com.saru.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserRegisterDto userRegisterDto){
        userService.saveUser(userRegisterDto);
        return ResponseEntity.status(200).body("User saved successfully");
    }

}
