package com.example.demo.controller;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.service.PredictionService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PredictionController {

    private final PredictionService service;
    private final StationRepository stationRepository;

    public PredictionController(PredictionService service,
                                StationRepository stationRepository) {
        this.service = service;
        this.stationRepository = stationRepository;
    }

    // Show Prediction Page with Stations
    @GetMapping("/prediction")
    public String showPredictionPage(Model model) {

        model.addAttribute("stations", stationRepository.findAll());
        return "prediction";
    }

    // Handle Prediction
    @PostMapping("/predict")
    public String predict(
            @RequestParam double batteryCapacity,
            @RequestParam double currentCharge,
            @RequestParam double targetCharge,
            @RequestParam Long stationId,
            Model model) {

        Optional<Station> optionalStation =
                stationRepository.findById(stationId);

        if (optionalStation.isEmpty()) {
            model.addAttribute("error", "Station not found!");
            model.addAttribute("stations", stationRepository.findAll());
            return "prediction";
        }

        Station station = optionalStation.get();

        double chargerPower = station.getPower();
        double costPerKwh = station.getCostPerKwh();

        double time = service.calculateChargingTime(
                batteryCapacity,
                currentCharge,
                targetCharge,
                chargerPower);

        String formattedTime = service.formatChargingTime(time);

        double cost = service.calculateChargingCost(
                batteryCapacity,
                currentCharge,
                targetCharge,
                costPerKwh);

        model.addAttribute("time", formattedTime);
        model.addAttribute("cost", cost);
        model.addAttribute("selectedStation", station);
        model.addAttribute("stations", stationRepository.findAll());
        model.addAttribute("success", "Calculation Completed Successfully!");

        return "prediction";
    }
}
