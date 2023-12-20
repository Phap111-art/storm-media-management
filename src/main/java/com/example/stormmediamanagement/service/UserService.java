package com.example.stormmediamanagement.service;

import com.example.stormmediamanagement.dto.request.CreateUserDto;
import com.example.stormmediamanagement.dto.request.LoginUserDto;
import com.example.stormmediamanagement.dto.response.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface UserService {
    ResponseEntity<CustomResponse> loginUser(LoginUserDto dto ,BindingResult result);
    ResponseEntity<CustomResponse> registerUser(CreateUserDto dto, BindingResult result);
}
