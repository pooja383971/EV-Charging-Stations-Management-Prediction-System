package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;

@Controller
public class StationController {

    private final StationRepository repository;

    public StationController(StationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stations")
    public String viewStations(Model model) {
        model.addAttribute("stations", repository.findAll());
        return "stations";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("station", new Station());
        return "add-station";
    }

    @PostMapping("/save")
    public String saveStation(@ModelAttribute Station station) {
        repository.save(station);
        return "redirect:/stations";
    }
}
