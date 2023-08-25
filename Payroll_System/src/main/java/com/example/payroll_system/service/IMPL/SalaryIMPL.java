package com.example.payroll_system.service.IMPL;

import com.example.payroll_system.model.Employee;
import com.example.payroll_system.model.Salary;
import com.example.payroll_system.repo.EmployeeRepo;
import com.example.payroll_system.repo.SalaryRepo;
import com.example.payroll_system.service.SalaryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SalaryIMPL implements SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public int addSalary(Salary salary) {
        Employee employee=employeeRepo.findById(salary.getEmpID())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"+" "+salary.getEmpID()+" "));
        float CycleDate=(float)ChronoUnit.DAYS.between(salary.getStartDate(), salary.getEndDate()) + 1;
        float NoPayValue=(employee.getMonthlySalary()/CycleDate)*salary.getAbsentDays();
        float BasePay= employee.getMonthlySalary()+employee.getAllowance()+(employee.getOvertimeRates()*salary.getOvertimeHours());
        float TaxRate=0.10f;
        float GrossPay=BasePay-(NoPayValue+BasePay*TaxRate);

        salary.setNoPayValue(NoPayValue);
        salary.setBasePay(BasePay);
        salary.setGrossPay(GrossPay);
        Salary salary1=new Salary(
                salary.getSalaryId(),
                salary.getEmpID(),
                salary.getStartDate(),
                salary.getEndDate(),
                salary.getLeavesTaken(),
                salary.getAbsentDays(),
                salary.getOvertimeHours(),
                salary.getNoPayValue(),
                salary.getBasePay(),
                salary.getGrossPay());

        salaryRepo.save(salary);
        return salary1.getEmpID();
    }

    @Override
    public List<Salary> getAllSalaries() {
        return salaryRepo.findAll();

    }

    @Override
    public void deleteSalarySheet(int salaryId) {
        Salary salary=salaryRepo.findById(salaryId)
                .orElseThrow(()->new EntityNotFoundException("SalaryId not found"));
        salaryRepo.delete(salary);
    }


//    @Override
//    public Salary calculateSalary(Salary salary) {
//
//        Employee employee=employeeRepo.findById(salary.getEmpID())
//                .orElseThrow(() -> new EntityNotFoundException("Employee not found"+" "+salary.getEmpID()+" "));
//
//        float CycleDate=(float)ChronoUnit.DAYS.between(salary.getStartDate(), salary.getEndDate()) + 1;
//        float NoPayValue=(employee.getMonthlySalary()/CycleDate)*salary.getAbsentDays();
//        float BasePay= employee.getMonthlySalary()+employee.getAllowance()+(employee.getOvertimeRates()*salary.getOvertimeHours());
//        float TaxRate=0.10f;
//        float GrossPay=BasePay-(NoPayValue+BasePay*TaxRate);
//
//        salary.setNoPayValue(NoPayValue);
//        salary.setBasePay(BasePay);
//        salary.setGrossPay(GrossPay);
//
//        return salaryRepo.save(salary);
//
//
//
//    }
}
