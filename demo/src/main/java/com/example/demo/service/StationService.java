package com.example.demo.service;

import com.example.demo.model.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    private final List<Station> stationList = new ArrayList<>();

    public List<Station> getAllStations() {
        return stationList;
    }

    public void saveStation(Station station) {
        stationList.add(station);
    }
}
