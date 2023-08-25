package com.example.payroll_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "full-Name")
    private String fullName;

    @Column(name = "monthly_Salary")
    private float monthlySalary;

    @Column(name = "overtime_Rates")
    private float overtimeRates;

    @Column(name = "allowance")
    private float allowance;

    public Employee() {
    }

    public Employee(int employeeId, String fullName, float monthlySalary, float overtimeRates, float allowance) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.monthlySalary = monthlySalary;
        this.overtimeRates = overtimeRates;
        this.allowance = allowance;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public float getOvertimeRates() {
        return overtimeRates;
    }

    public void setOvertimeRates(float overtimeRates) {
        this.overtimeRates = overtimeRates;
    }

    public float getAllowance() {
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", fullName='" + fullName + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", overtimeRates=" + overtimeRates +
                ", allowance=" + allowance +
                '}';
    }
}
