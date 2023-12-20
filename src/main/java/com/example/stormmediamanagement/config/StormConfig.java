package com.example.stormmediamanagement.config;

import com.example.stormmediamanagement.entity.Storm;
import com.example.stormmediamanagement.repository.StormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StormConfig {
    @Autowired
    private StormRepository repository;

    @Bean
    public List<Storm> init() {
        repository.deleteAll();
        Storm st1 = Storm.builder().cityName("da nang").affectedAreas(1).build();
        Storm st2 = Storm.builder().cityName("hue").affectedAreas(2).build();
        Storm st3 = Storm.builder().cityName("quy nhon").affectedAreas(2).build();
        Storm st4 = Storm.builder().cityName("hanoi").affectedAreas(2).build();
        Storm st5 = Storm.builder().cityName("saigon").affectedAreas(2).build();


        return repository.saveAll(List.of(st1, st2,st3,st4,st5));
    }
}
