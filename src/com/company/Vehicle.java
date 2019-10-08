package com.company;

class Vehicle {
    
    private String plateNumber;
    private String model;
    
    Vehicle(String plateNum, String model) {
        this.plateNumber = plateNum;
        this.model = model;
    }
    
    String getPlateNumber() {
        return plateNumber;
    }
    
    String getModel() {
        return model;
    }
}