package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public interface Books {
    double getWeight();
    double estimatedPopularity();
    @PostConstruct
    void onInit();
    @PreDestroy
    void onDestroy();
}
