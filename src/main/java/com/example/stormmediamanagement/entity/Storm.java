package com.example.stormmediamanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "storms")
@Builder
public class Storm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    protected UUID stormId;
    private String cityName;
    private int affectedAreas;
    private LocalDateTime detectedTime;


    @PrePersist
    protected void onCreate() {
        detectedTime = LocalDateTime.now();
    }

}
