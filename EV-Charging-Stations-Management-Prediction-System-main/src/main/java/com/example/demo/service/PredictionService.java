package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    /**
     * Calculate charging time in hours
     * Max limit: 4 hours
     */
    public double calculateChargingTime(double batteryCapacity,
                                        double currentCharge,
                                        double targetCharge,
                                        double chargerPower) {

        // Validation: Target must be greater than current
        if (targetCharge <= currentCharge) {
            return 0.0;
        }

        // Energy required in kWh
        double energyNeeded =
                batteryCapacity * (targetCharge - currentCharge) / 100;

        // Time calculation (Hours)
        double time = energyNeeded / chargerPower;

        // Limit maximum charging time to 4 hours
        if (time > 4) {
            time = 4;
        }

        // Round to 2 decimal places
        return Math.round(time * 100.0) / 100.0;
    }

    /**
     * Calculate charging cost
     */
    public double calculateChargingCost(double batteryCapacity,
                                        double currentCharge,
                                        double targetCharge,
                                        double costPerKwh) {

        if (targetCharge <= currentCharge) {
            return 0.0;
        }

        double energyNeeded =
                batteryCapacity * (targetCharge - currentCharge) / 100;

        double totalCost = energyNeeded * costPerKwh;

        // Round to 2 decimal places
        return Math.round(totalCost * 100.0) / 100.0;
    }

    /**
     * Convert decimal hours into formatted Hours + Minutes
     * Example: 1.5 -> 1 hr 30 min
     */
    public String formatChargingTime(double hours) {

        int hrs = (int) hours;
        int minutes = (int) Math.round((hours - hrs) * 60);

        return hrs + " hr " + minutes + " min";
    }
}
