package com.example.demo.controller;

import com.example.demo.entity.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StationController {

    private final StationRepository stationRepository;

    // Constructor Injection
    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    // ✅ HOME PAGE
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // ✅ VIEW STATIONS (YOUR REQUIRED CODE)
    @GetMapping("/stations")
    public String viewStations(Model model) {
        model.addAttribute("stations", stationRepository.findAll());
        return "stations";
    }

    // ✅ OPEN ADD STATION PAGE
    @GetMapping("/add")
    public String showAddStationPage(Model model) {
        model.addAttribute("station", new Station());
        return "add-station";
    }

    // ✅ SAVE STATION
    @PostMapping("/save")
    public String saveStation(@ModelAttribute Station station) {
        stationRepository.save(station);
        return "redirect:/stations";
    }

    // ✅ PREDICTION PAGE
    @GetMapping("/prediction")
    public String showPredictionPage() {
        return "prediction";
    }

    // ✅ PREDICTION LOGIC
    @PostMapping("/predict")
    public String predictChargingTime(
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
