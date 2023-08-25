package com.example.payroll_system.Controller;

import com.example.payroll_system.DTO.EmployeeDTO;
import com.example.payroll_system.model.Salary;
import com.example.payroll_system.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @PostMapping(path = "/register")
    public int SaveEmployee(@RequestBody Salary salary){
        int id=salaryService.addSalary(salary);
        return id;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteSalarySheet(@PathVariable int id){
        salaryService.deleteSalarySheet(id);
        return ResponseEntity.ok("Salary Sheet Deleted successfully");
    }
    //    @PostMapping("/calculate")
//    public ResponseEntity<Salary> CalculateSalary(@RequestBody Salary salary){
//        Salary calSalary=salaryService.calculateSalary(salary);
//        return ResponseEntity.status(HttpStatus.CREATED).body(calSalary);
//    }
}
