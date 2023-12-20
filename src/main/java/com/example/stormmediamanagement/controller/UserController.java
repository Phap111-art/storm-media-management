package com.example.stormmediamanagement.controller;

import com.example.stormmediamanagement.dto.request.CreateUserDto;
import com.example.stormmediamanagement.dto.request.LoginUserDto;
import com.example.stormmediamanagement.dto.response.CustomResponse;
import com.example.stormmediamanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public record UserController(UserService userService) {

    @PostMapping("/register")
    public ResponseEntity<CustomResponse> registerUser(@RequestBody @Valid CreateUserDto dto, BindingResult result){
        return userService.registerUser(dto,result);
    }
    @PostMapping("/login")
    public ResponseEntity<CustomResponse> loginUser(@RequestBody @Valid LoginUserDto dto, BindingResult result){
        return userService.loginUser(dto,result);
    }
}
