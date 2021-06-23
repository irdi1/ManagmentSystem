package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Employee;
import com.ManagmentSystem.FleetApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    // Get all the States
    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());

        return "employee";
    }

    // Add State
    @PostMapping(value = "/employees/addNew")
    public String addNew(Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees";
    }

    @RequestMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {

        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/deletes", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String update(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

//    //Assign Employee Username
    @RequestMapping(value = "/employees/assignUsername")
    public String assignUsername(Integer id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }
}
