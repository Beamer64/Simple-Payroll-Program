package com.company;

import java.util.ArrayList;

public class PayrollSystem {
    
    //main method
    //shows the main menu selection
    public static void main(String[] args) {
        ArrayList<Employee> EmpList = new ArrayList<>();
        
        do {
            int task = Menu();
            switch (task) {
                case 1:
                    FullTime newFt = addFullTimeEmp();
                    EmpList.add(newFt);
                    
                    break;
                
                case 2:
                    PartTime newPt = addPartTimeEmp();
                    EmpList.add(newPt);
                    
                    break;
                
                case 3:
                    Payroll(EmpList);
                    break;
                
                case 4:
                    Exit();
                
                default:
                    break;
            }
        }
        while (true);
        
    }
    
    //the main menu selection
    private static int Menu() {
        
        System.out.println();
        System.out.println("Please Select an option.");
        System.out.println();
        
        System.out.println("Option:      Task:");
        System.out.println("  1.         Add Full-time Employee");
        System.out.println();
        
        System.out.println("  2.         Add Part-time Employee");
        System.out.println();
        
        System.out.println("  3.         Calculate the payroll");
        System.out.println();
        
        System.out.println("  4.         Exit");
        System.out.println();
        
        return TextIO.getInt();
        
    }
    
    //updates EmpList with new full-time employee info
    private static FullTime addFullTimeEmp() {
        TextIO.getln();
        System.out.println();
        
        System.out.println("Enter Employee Name: ");
        String name = TextIO.getln();
        
        String grammar = "'s";
        if (name.endsWith("s")) {
            grammar = "'";
        }
        
        System.out.println("Enter " + name + grammar + " Id: ");
        int id = TextIO.getInt();
        
        System.out.println("Enter " + name + grammar + " Salary: ");
        System.out.print("$");
        double salary = TextIO.getDouble();
        
        System.out.println("Enter " + name + grammar + " Bonus: ");
        System.out.print("$");
        double bonus = TextIO.getDouble();
        
        
        return new FullTime(id, name, salary, bonus, hasVehicle());
    }
    
    //updates EmpList with new part-time employee info
    private static PartTime addPartTimeEmp() {
        TextIO.getln();
        System.out.println();
        
        System.out.println("Enter Employee Name: ");
        String name = TextIO.getln();
        
        //provides correct grammar
        String grammar = "'s";
        if (name.endsWith("s")) {
            grammar = "'";
        }
        
        System.out.println("Enter " + name + grammar + " Id: ");
        int id = TextIO.getInt();
        
        System.out.println("Enter " + name + grammar + " hourly rate: ");
        System.out.print("$");
        double rate = TextIO.getDouble();
        
        System.out.println("Enter " + name + grammar + " hours worked: ");
        double hoursWorked = TextIO.getDouble();
        
        Vehicle vehicle = hasVehicle();
        
        return new PartTime(id, name, hoursWorked, rate, vehicle);
    }
    
    //determines if employee needs a parking spot for their vehicle
    private static Vehicle hasVehicle() {
        System.out.println();
        TextIO.getln();
        
        while (true) {
            System.out.println("Yes or No: Does this employee need parking?");
            String needsParking = TextIO.getln();
            
            if (needsParking.matches("yes|Yes|y|Y")) {
                System.out.println();
                
                System.out.println("Enter plate number: ");
                String plateNum = TextIO.getln();
                
                System.out.println("Enter vehicle model: ");
                String model = TextIO.getln();
                
                return new Vehicle(plateNum, model);
            }
            
            else if (needsParking.matches("no|No|n|N")) {
                return null;
            }
        }
    }
    
    //displays employee info along with total company payroll costs
    private static void Payroll(ArrayList<Employee> pEmpList) {
        System.out.println();
        double totalCompanyPay = 0;
        for (Employee employee : pEmpList) {
            System.out.println("-------------------------------");
            double employeePay = employee.calculatePayroll();
            Vehicle vehicle = employee.getVehicle();
            
            String needsParking;
            if (vehicle == null) {
                needsParking = "No";
            }
            else {
                needsParking = "Yes";
            }
            
            System.out.println("Employee: " + employee.getName());
            System.out.println("ID Number: " + employee.getEmpId());
            System.out.println("Needs Parking? " + needsParking);
            
            if (vehicle != null) {
                System.out.println("Vehicle Plate: " + vehicle.getPlateNumber());
                System.out.println("Vehicle Model: " + vehicle.getModel());
            }
            
            System.out.println("Take Home Pay: " + "$" + employeePay);
            
            totalCompanyPay = totalCompanyPay + employeePay;
            
        }
        System.out.println("-------------------------------");
        System.out.println("Total overall payroll: " + "$" + totalCompanyPay);
        System.out.println("-------------------------------");
        
    }
    
    //exit the program
    private static void Exit() {
        System.exit(0);
    }
}