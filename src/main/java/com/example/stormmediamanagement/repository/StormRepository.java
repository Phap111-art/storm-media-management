package com.example.stormmediamanagement.repository;

import com.example.stormmediamanagement.entity.Storm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StormRepository extends JpaRepository<Storm, UUID> {
    List<Storm> findAllByOrderByDetectedTimeDesc();

    List<Storm> findByCityNameOrderByDetectedTimeDesc(String cityName);
}
