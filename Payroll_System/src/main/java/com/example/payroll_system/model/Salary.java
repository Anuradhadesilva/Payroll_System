package com.example.payroll_system.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @Column(name = "salary_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SalaryId;

    @Column(name = "emp_Id")
    private int empID;

    @Column(name = "start_Date")
    private LocalDate startDate;

    @Column(name = "end_Date")
    private LocalDate endDate;

    @Column(name = "leaves_Taken")
    private int leavesTaken;

    @Column(name = "absent_Days")
    private int absentDays;

    @Column(name = "overtime_Hours")
    private int overtimeHours;

    @Column(name = "noPay_Value")
    private float noPayValue;

    @Column(name = "base_Pay")
    private float basePay;

    @Column(name = "gross_Pay")
    private float grossPay;

    public Salary() {
    }

    public Salary(int salaryId, int empID, LocalDate startDate, LocalDate endDate, int leavesTaken, int absentDays, int overtimeHours, float noPayValue, float basePay, float grossPay) {
        SalaryId = salaryId;
        this.empID = empID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leavesTaken = leavesTaken;
        this.absentDays = absentDays;
        this.overtimeHours = overtimeHours;
        this.noPayValue = noPayValue;
        this.basePay = basePay;
        this.grossPay = grossPay;
    }

    public int getSalaryId() {
        return SalaryId;
    }

    public void setSalaryId(int salaryId) {
        SalaryId = salaryId;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(int absentDays) {
        this.absentDays = absentDays;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public float getNoPayValue() {
        return noPayValue;
    }

    public void setNoPayValue(float noPayValue) {
        this.noPayValue = noPayValue;
    }

    public float getBasePay() {
        return basePay;
    }

    public void setBasePay(float basePay) {
        this.basePay = basePay;
    }

    public float getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(float grossPay) {
        this.grossPay = grossPay;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "SalaryId=" + SalaryId +
                ", empID=" + empID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leavesTaken=" + leavesTaken +
                ", absentDays=" + absentDays +
                ", overtimeHours=" + overtimeHours +
                ", noPayValue=" + noPayValue +
                ", basePay=" + basePay +
                ", grossPay=" + grossPay +
                '}';
    }
}
