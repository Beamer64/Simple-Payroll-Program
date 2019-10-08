package com.company;

public abstract class Employee {
    
    private int empId;
    private String name;
    private Vehicle vehicle;
    
    
    Employee(int EmpId, String Name, Vehicle V) {
        empId = EmpId;
        name = Name;
        vehicle = V;
    }
    
    public abstract double calculatePayroll();
    
    int getEmpId() {
        return empId;
    }
    
    String getName() {
        return name;
    }
    
    Vehicle getVehicle() {
        return vehicle;
    }
}