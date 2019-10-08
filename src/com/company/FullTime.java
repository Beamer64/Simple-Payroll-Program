package com.company;

public class FullTime extends Employee {
    
    private double salary;
    private double bonus;
    
    
    FullTime(int id, String name, double salary, double bonus, Vehicle vehicle) {
        super(id, name, vehicle);
        this.salary = salary;
        this.bonus = bonus;
    }
    
    //calculates full-time employees payroll
    @Override
    public double calculatePayroll() {
        System.out.println("Full-time employee.");
        return (this.getSalary() + this.getBonus());
    }
    
    private double getSalary() {
        return salary;
    }
    
    private double getBonus() {
        return bonus;
    }
}