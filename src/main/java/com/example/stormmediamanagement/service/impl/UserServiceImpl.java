package com.example.stormmediamanagement.service.impl;

import com.example.stormmediamanagement.dto.request.CreateUserDto;
import com.example.stormmediamanagement.dto.request.LoginUserDto;
import com.example.stormmediamanagement.dto.response.CustomResponse;
import com.example.stormmediamanagement.entity.User;
import com.example.stormmediamanagement.enums.SecretKey;
import com.example.stormmediamanagement.exception.CustomException;
import com.example.stormmediamanagement.mapper.DataMapper;
import com.example.stormmediamanagement.repository.UserRepository;
import com.example.stormmediamanagement.service.UserService;
import com.example.stormmediamanagement.ultis.TokenUtil;
import com.example.stormmediamanagement.ultis.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final String keyToken = SecretKey.KEY_DEMO.name();
    @Override
    public ResponseEntity<CustomResponse> loginUser(LoginUserDto dto, BindingResult result) {
        try {

            if (TokenUtil.verifyToken(keyToken,dto.getUsername(),dto.getPassword()) ||!userRepository.findByUsername(dto.getUsername()).isPresent() ||
                    !userRepository.findByPassword(dto.getPassword()).isPresent()){
                throw new CustomException(" Invalid username or password" + dto.getUsername(), HttpStatus.NOT_FOUND);
            }
            if (result.hasErrors()) {
                throw new CustomException(ValidationUtils.getValidationErrorString(result), HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse("Login successfully!", HttpStatus.CREATED,"" ));
        } catch ( CustomException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(new CustomResponse(e.getMessage(), e.getHttpStatus(), ""));
        }
    }

    @Override
    public ResponseEntity<CustomResponse> registerUser(CreateUserDto dto, BindingResult result) {
        try {
            if (result.hasErrors()) {
                throw new CustomException(ValidationUtils.getValidationErrorString(result), HttpStatus.BAD_REQUEST);
            }
            User toEntity = DataMapper.toEntity(dto,User.class);
            toEntity.setPassword(TokenUtil.generateToken(dto.getUsername(),keyToken));
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CustomResponse(
                            "User created successfully!",
                            HttpStatus.CREATED,
                            userRepository.save(toEntity) ));
        } catch ( CustomException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(new CustomResponse(e.getMessage(),
                            e.getHttpStatus(), ""));
        }

    }
}
