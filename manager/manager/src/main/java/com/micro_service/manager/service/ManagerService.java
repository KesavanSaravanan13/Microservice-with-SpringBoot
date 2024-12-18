package com.micro_service.manager.service;

import com.micro_service.manager.entity.Employee;
import com.micro_service.manager.entity.Manager;
import com.micro_service.manager.repository.EmployeeGetter;
import com.micro_service.manager.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EmployeeGetter employeeGetter;

    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    public Manager createManager(Manager Manager) {
        Manager existingManager = new Manager();
        existingManager.setMngName(Manager.getMngName());
        existingManager.setAddress(Manager.getAddress());
        existingManager.setMail(Manager.getMail());
        existingManager.setPhNo(Manager.getPhNo());
        return this.managerRepository.save(existingManager);
    }

    public Manager getManagerById(Long id) {
        return this.managerRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    public Employee getEmployeeById(Long id) {
        return this.employeeGetter.getEmployeeById(id);
    }
}
