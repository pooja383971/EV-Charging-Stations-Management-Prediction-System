package com.example.demo.model;

public class Vehicle {

    private String batteryType;
    private int motorCapacity; // 1200W or 1400W
    private int range = 100;
    private String application;
    private String bodyType = "Closed Body";

    public String getBatteryType() { return batteryType; }
    public void setBatteryType(String batteryType) { this.batteryType = batteryType; }

    public int getMotorCapacity() { return motorCapacity; }
    public void setMotorCapacity(int motorCapacity) { this.motorCapacity = motorCapacity; }

    public int getRange() { return range; }
    public String getApplication() { return application; }
    public void setApplication(String application) { this.application = application; }

    public String getBodyType() { return bodyType; }
}
