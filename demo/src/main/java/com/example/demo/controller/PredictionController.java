package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PredictionController {

    // Open prediction page
    @GetMapping("/prediction")
    public String predictionPage() {
        return "prediction";
    }

    // Handle prediction calculation
    @PostMapping("/predict")
    public String predict(
            @RequestParam double capacity,
            @RequestParam double current,
            @RequestParam double target,
            @RequestParam double power,
            Model model) {

        double energyNeeded = capacity * (target - current) / 100.0;
        double time = energyNeeded / power;

        model.addAttribute("time", String.format("%.2f", time));
        return "prediction";
    }
}
