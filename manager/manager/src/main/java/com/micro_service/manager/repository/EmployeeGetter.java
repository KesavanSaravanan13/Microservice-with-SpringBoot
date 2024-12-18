package com.micro_service.manager.repository;


import com.micro_service.manager.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("EMPLOYEE-SERVICE")
public interface EmployeeGetter {
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id);
}
