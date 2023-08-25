//package com.example.payroll_system.DTO;
//
//import java.time.LocalDate;
//
//public class SalaryDTO {
//    private int Id;
//    private int employeeID;
//    private LocalDate startDate;
//    private LocalDate endDate;
//    private int leavesTaken;
//    private int absentDays;
//    private int overtimeHours;
//    private float noPayValue;
//    private float basePay;
//    private float grossPay;
//
//    public SalaryDTO() {
//    }
//
//    public SalaryDTO(int id, int employeeID, LocalDate startDate, LocalDate endDate, int leavesTaken, int absentDays, int overtimeHours, float noPayValue, float basePay, float grossPay) {
//        Id = id;
//        this.employeeID = employeeID;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.leavesTaken = leavesTaken;
//        this.absentDays = absentDays;
//        this.overtimeHours = overtimeHours;
//        this.noPayValue = noPayValue;
//        this.basePay = basePay;
//        this.grossPay = grossPay;
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public int getEmployeeID() {
//        return employeeID;
//    }
//
//    public void setEmployeeID(int employeeID) {
//        this.employeeID = employeeID;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
//
//    public int getLeavesTaken() {
//        return leavesTaken;
//    }
//
//    public void setLeavesTaken(int leavesTaken) {
//        this.leavesTaken = leavesTaken;
//    }
//
//    public int getAbsentDays() {
//        return absentDays;
//    }
//
//    public void setAbsentDays(int absentDays) {
//        this.absentDays = absentDays;
//    }
//
//    public int getOvertimeHours() {
//        return overtimeHours;
//    }
//
//    public void setOvertimeHours(int overtimeHours) {
//        this.overtimeHours = overtimeHours;
//    }
//
//    public float getNoPayValue() {
//        return noPayValue;
//    }
//
//    public void setNoPayValue(float noPayValue) {
//        this.noPayValue = noPayValue;
//    }
//
//    public float getBasePay() {
//        return basePay;
//    }
//
//    public void setBasePay(float basePay) {
//        this.basePay = basePay;
//    }
//
//    public float getGrossPay() {
//        return grossPay;
//    }
//
//    public void setGrossPay(float grossPay) {
//        this.grossPay = grossPay;
//    }
//
//    @Override
//    public String toString() {
//        return "SalaryDTO{" +
//                "Id=" + Id +
//                ", employeeID=" + employeeID +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", leavesTaken=" + leavesTaken +
//                ", absentDays=" + absentDays +
//                ", overtimeHours=" + overtimeHours +
//                ", noPayValue=" + noPayValue +
//                ", basePay=" + basePay +
//                ", grossPay=" + grossPay +
//                '}';
//    }
//}
