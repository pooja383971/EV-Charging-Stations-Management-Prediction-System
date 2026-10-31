package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double power;
    private double costPerKwh;

    public Station() {}

    public Station(String name, String location, double power, double costPerKwh) {
        this.name = name;
        this.location = location;
        this.power = power;
        this.costPerKwh = costPerKwh;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public double getPower() { return power; }
    public double getCostPerKwh() { return costPerKwh; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setPower(double power) { this.power = power; }
    public void setCostPerKwh(double costPerKwh) { this.costPerKwh = costPerKwh; }
}
