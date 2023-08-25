package com.example.payroll_system.service.IMPL;

import com.example.payroll_system.DTO.EmployeeDTO;
import com.example.payroll_system.model.Employee;
import com.example.payroll_system.repo.EmployeeRepo;
import com.example.payroll_system.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeIMPL(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee=new Employee(
            employeeDTO.getEmployeeId(),
            employeeDTO.getFullName(),
            employeeDTO.getMonthlySalary(),
            employeeDTO.getOvertimeRates(),
            employeeDTO.getAllowance() );

        employeeRepo.save(employee);
        return employee.getFullName();
    }

    @Override
    public void updateEmployee(EmployeeDTO updateEmployeeDTO) {
        Employee existingEmployee=employeeRepo.findById(updateEmployeeDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        existingEmployee.setMonthlySalary(updateEmployeeDTO.getMonthlySalary());
        existingEmployee.setOvertimeRates(updateEmployeeDTO.getOvertimeRates());
        existingEmployee.setAllowance(updateEmployeeDTO.getAllowance());

        employeeRepo.save(existingEmployee);

    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee existingEmployee=employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeRepo.delete(existingEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees=employeeRepo.findAll();
        return employees.stream()
                .map(employee -> new EmployeeDTO(
                        employee.getEmployeeId(),
                        employee.getFullName(),
                        employee.getMonthlySalary(),
                        employee.getOvertimeRates(),
                        employee.getAllowance()
                ))
                .collect(Collectors.toList());
    }

}




