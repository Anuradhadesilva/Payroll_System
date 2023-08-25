package com.example.payroll_system.service;

import com.example.payroll_system.DTO.EmployeeDTO;
import com.example.payroll_system.model.Salary;

import java.util.List;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO updateEmployeeDTO);

    void deleteEmployee(int employeeId);

    List<EmployeeDTO> getAllEmployees();


}
