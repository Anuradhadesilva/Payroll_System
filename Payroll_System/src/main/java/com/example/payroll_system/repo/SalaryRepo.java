package com.example.payroll_system.repo;

import com.example.payroll_system.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;



@Repository
public interface SalaryRepo extends JpaRepository<Salary, Integer> {
    // Custom query methods if needed
}