package com.example.payroll_system.Controller;


import com.example.payroll_system.DTO.EmployeeDTO;
import com.example.payroll_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/register")
    public String SaveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id=employeeService.addEmployee(employeeDTO);
        return id;
    }

    @GetMapping("/getAll")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
//    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
//        List<EmployeeDTO> employeeDTO=employeeService.getAllEmployees();
//        return ResponseEntity.ok(employeeDTO);
//    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> EditEmployee(@PathVariable int id, @RequestBody EmployeeDTO updateEmployeeDTO) {
        if (updateEmployeeDTO.getEmployeeId() != id) {
            return ResponseEntity.badRequest().body("Employee ID mismatch");
        }
        employeeService.updateEmployee(updateEmployeeDTO);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<String> DeleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted successfully");
    }

}
