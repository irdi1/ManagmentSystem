package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.EmployeeType;
import com.ManagmentSystem.FleetApp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    // Get all the JobTitles
    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model) {
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        return "employeeType";
    }

    // Add EmployeeTypes
    @PostMapping(value = "/employeeTypes/addNew")
    public String addNew(EmployeeType employeeTypes) {

        employeeTypeService.save(employeeTypes);

        return "redirect:/employeeTypes";
    }

    @RequestMapping("/employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {

        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employeeTypes/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeTypes) {
        employeeTypeService.save(employeeTypes);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
