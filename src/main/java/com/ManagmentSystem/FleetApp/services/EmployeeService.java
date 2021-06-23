package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Employee;
import com.ManagmentSystem.FleetApp.models.User;
import com.ManagmentSystem.FleetApp.repositories.EmployeeRepository;
import com.ManagmentSystem.FleetApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

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

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    //Set the Username of the employee where firstname and lastname match
    public void assignUsername(Integer id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }

}
