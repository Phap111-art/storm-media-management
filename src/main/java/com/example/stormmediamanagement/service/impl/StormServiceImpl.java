package com.example.stormmediamanagement.service.impl;

import com.example.stormmediamanagement.dto.response.CustomResponse;
import com.example.stormmediamanagement.entity.Storm;
import com.example.stormmediamanagement.exception.CustomException;
import com.example.stormmediamanagement.repository.StormRepository;
import com.example.stormmediamanagement.service.StormService;
import com.example.stormmediamanagement.ultis.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StormServiceImpl implements StormService {
    private final StormRepository stormRepository;

    @Override
    public ResponseEntity<CustomResponse> retrieveAllStorms() {
        List<Storm> ls = stormRepository.findAllByOrderByDetectedTimeDesc();
        try {
            if (ls.isEmpty()) {
                throw new CustomException("storm not null !", HttpStatus.BAD_REQUEST);

            }
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CustomResponse(
                            "get all storm successfully!",
                            HttpStatus.CREATED,
                            ls));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(new CustomResponse(e.getMessage(),
                            e.getHttpStatus(), ""));

        }

    }

    @Override
    public ResponseEntity<CustomResponse> retrieveStormsByCity(String cityName) {
        List<Storm> ls = stormRepository.findByCityNameOrderByDetectedTimeDesc(cityName);
        try {
            if (ls.isEmpty()) {
                throw new CustomException("cityName not found in database !", HttpStatus.BAD_REQUEST);

            }
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CustomResponse(
                            "get all by cityName successfully!",
                            HttpStatus.CREATED,
                            ls));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getHttpStatus())
                    .body(new CustomResponse(e.getMessage(),
                            e.getHttpStatus(), ""));

        }
    }
}
