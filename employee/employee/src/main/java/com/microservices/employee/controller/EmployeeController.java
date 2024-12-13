package com.microservices.employee.controller;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }
}
