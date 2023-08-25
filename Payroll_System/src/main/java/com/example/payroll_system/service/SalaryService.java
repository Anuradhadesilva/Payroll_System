package com.example.payroll_system.service;

import com.example.payroll_system.model.Salary;

import java.util.List;

public interface SalaryService {
    int addSalary(Salary salary);
    List<Salary> getAllSalaries();

    void deleteSalarySheet(int salaryId);
//    Salary calculateSalary(Salary salary);
}
