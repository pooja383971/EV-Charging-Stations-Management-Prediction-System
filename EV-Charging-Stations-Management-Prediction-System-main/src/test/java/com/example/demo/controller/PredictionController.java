package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PredictionController {

    @GetMapping("/prediction")
    public String showPredictionPage() {
        return "prediction";
    }

    @PostMapping("/predict")
    public String predictChargingTime(
            @RequestParam("capacity") double capacity,
            @RequestParam("current") double current,
            @RequestParam("target") double target,
            Model model) {

        // Simple charging formula
        double energyNeeded = capacity * (target - current) / 100.0;

        double chargerPower = 50; // assume 50kW charger
        double time = energyNeeded / chargerPower;

        model.addAttribute("result", String.format("%.2f hours", time));

        return "prediction";
    }
}
