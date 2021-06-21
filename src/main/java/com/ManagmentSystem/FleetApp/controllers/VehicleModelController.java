package com.ManagmentSystem.FleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleModelController {

    @GetMapping("/vehiclesModels")
    public String getVehicleModel() {
        return "vehicleModel";
    }
}
