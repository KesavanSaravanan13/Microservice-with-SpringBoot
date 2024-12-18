package com.micro_service.manager.controller;

import com.micro_service.manager.entity.Employee;
import com.micro_service.manager.entity.Manager;
import com.micro_service.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping
    public List<Manager> getAllManager() {
        return managerService.getAllManager();
    }

    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable Long id){
        return this.managerService.getManagerById(id);
    }

    @PostMapping
    public Manager createManager(@RequestBody Manager Manager){
        return managerService.createManager(Manager);
    }

    @GetMapping("/get-employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.managerService.getEmployeeById(id);
    }
}
