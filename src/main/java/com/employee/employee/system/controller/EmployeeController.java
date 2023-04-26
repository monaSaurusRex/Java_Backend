package com.employee.employee.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.employee.system.repo.EmployeeRepo;

import com.employee.employee.system.model.Employee;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional <Employee> findOne(Employee employee) {
        return employeeRepo.findById(employee.getEmpId());
    }

    @PostMapping
    public Employee save(@Validated @NonNull @RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@Validated @NonNull @RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

}
