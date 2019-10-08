package com.company;

public class PartTime extends Employee {
    
    private double payRate;
    private double hoursWorked;
    
    PartTime(int id, String name, double hoursWorked, double rate, Vehicle vehicle) {
        super(id, name, vehicle);
        this.payRate = rate;
        this.hoursWorked = hoursWorked;
    }
    
    //calculates part-time employees payroll
    @Override
    public double calculatePayroll() {
        System.out.println("Part-time employee.");
        return (this.getHoursWorked() * this.getPayRate());
    }
    
    private double getPayRate() {
        return payRate;
    }
    
    private double getHoursWorked() {
        return hoursWorked;
    }
}