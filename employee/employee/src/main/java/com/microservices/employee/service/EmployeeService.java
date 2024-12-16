package com.microservices.employee.service;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        Employee existingEmployee = new Employee();
        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setMail(employee.getMail());
        existingEmployee.setPhNo(employee.getPhNo());
        return this.employeeRepository.save(existingEmployee);
    }

    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }
}
