package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Employee;
import com.ManagmentSystem.FleetApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
