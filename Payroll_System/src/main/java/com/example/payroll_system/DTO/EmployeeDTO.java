package com.example.payroll_system.DTO;

import com.example.payroll_system.model.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDTO {

    private int employeeId;
    private String fullName;
    private float monthlySalary;
    private float overtimeRates;
    private float allowance;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int employeeId, String fullName, float monthlySalary, float overtimeRates, float allowance) {
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
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", fullName='" + fullName + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", overtimeRates=" + overtimeRates +
                ", allowance=" + allowance +
                '}';
    }
}
