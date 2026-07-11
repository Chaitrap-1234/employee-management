package com.example.ems;

public class App {

    // Method to calculate net salary
    public static double net(double basicSalary,
                             double allowance,
                             double deduction) {

        return basicSalary + allowance - deduction;
    }

    // Main method
    public static void main(String[] args) {

        double basicSalary = 50000;
        double allowance = 5000;
        double deduction = 2000;

        double netSalary = net(basicSalary, allowance, deduction);

        System.out.println("Employee Salary Details");
        System.out.println("------------------------");
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Allowance    : " + allowance);
        System.out.println("Deduction    : " + deduction);
        System.out.println("------------------------");
        System.out.println("Net Salary   : " + netSalary);
    }
}
