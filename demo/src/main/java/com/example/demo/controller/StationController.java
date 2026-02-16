package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;

@Controller
public class StationController {

    @Autowired
    private StationRepository repo;

    // ✅ Show all stations
    @GetMapping("/stations")
    public String listStations(Model model) {
        model.addAttribute("stations", repo.findAll());
        return "stations";   // stations.html
    }

    // ✅ Open Add Station page
    @GetMapping("/add")
    public String showAddStation(Model model) {
        model.addAttribute("station", new Station());
        return "add-station";   // add-station.html
    }

    // ✅ Save station
    @PostMapping("/save")
    public String saveStation(@ModelAttribute Station station) {
        repo.save(station);
        return "redirect:/stations";
    }

    // ✅ Delete station
    @GetMapping("/delete/{id}")
    public String deleteStation(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/stations";
    }

    // ✅ Edit station
    @GetMapping("/edit/{id}")
    public String editStation(@PathVariable Long id, Model model) {
        Station station = repo.findById(id).orElse(null);
        model.addAttribute("station", station);
        return "add-station";   // reuse same form
    }
}
