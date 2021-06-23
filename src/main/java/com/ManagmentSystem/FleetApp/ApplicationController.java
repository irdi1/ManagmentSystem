package com.ManagmentSystem.FleetApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
