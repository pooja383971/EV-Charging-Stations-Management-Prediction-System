package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    public String predictLoad(int total, int available) {
        int used = total - available;

        if (used > total * 0.7)
            return "HIGH";
        else if (used > total * 0.3)
            return "MEDIUM";
        else
            return "LOW";
    }
}
