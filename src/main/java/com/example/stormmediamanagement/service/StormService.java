package com.example.stormmediamanagement.service;

import com.example.stormmediamanagement.dto.response.CustomResponse;
import com.example.stormmediamanagement.entity.Storm;
import com.example.stormmediamanagement.repository.StormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StormService {

    ResponseEntity<CustomResponse> retrieveAllStorms();

    ResponseEntity<CustomResponse> retrieveStormsByCity(String cityName);


}
