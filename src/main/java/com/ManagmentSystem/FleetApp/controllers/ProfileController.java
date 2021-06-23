package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
@Controller
public class ProfileController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        model.addAttribute("profile", employeeService.findByUsername(un));
        return "profile";
    }
}
