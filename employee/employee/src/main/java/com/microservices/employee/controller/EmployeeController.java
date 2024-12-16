package com.microservices.employee.controller;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
}
