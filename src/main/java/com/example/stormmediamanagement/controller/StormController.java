package com.example.stormmediamanagement.controller;

import com.example.stormmediamanagement.dto.request.CreateUserDto;
import com.example.stormmediamanagement.dto.request.LoginUserDto;
import com.example.stormmediamanagement.dto.response.CustomResponse;
import com.example.stormmediamanagement.service.StormService;
import com.example.stormmediamanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storms")
public record StormController(StormService stormService) {

    @GetMapping("/retrieve-all-storm")
    public ResponseEntity<CustomResponse> retrieveAllStorm(){
        return stormService.retrieveAllStorms();
    }
    @GetMapping("/retrieve-storm-by-city/{cityName}")
    public ResponseEntity<CustomResponse> retrieveStormsByCity(@PathVariable String cityName){
        return stormService.retrieveStormsByCity(cityName);
    }
}
