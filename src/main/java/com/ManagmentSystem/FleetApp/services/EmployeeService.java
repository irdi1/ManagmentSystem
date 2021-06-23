package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Employee;
import com.ManagmentSystem.FleetApp.models.Employee;
import com.ManagmentSystem.FleetApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //Find Employee by Id
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    //Delete by Employee id
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
