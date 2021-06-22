package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.EmployeeType;
import com.ManagmentSystem.FleetApp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    // Return list of states
    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    //Save new Location
    public void  save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    //Find Location by Id
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
