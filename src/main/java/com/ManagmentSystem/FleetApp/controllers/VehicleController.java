package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Vehicle;
import com.ManagmentSystem.FleetApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired private VehicleService vehicleService;
    @Autowired private VehicleTypeService vehicleTypeService;
    @Autowired private VehicleMakeService vehicleMakeService;
    @Autowired private VehicleStatusService vehicleStatusService;
    @Autowired private EmployeeService employeeService;
    @Autowired private VehicleModelService vehicleModelService;
    @Autowired private LocationService locationService;




    // returns all the Countries to the HTML file
    @GetMapping("/vehicles")
    public String getVehicles(Model model) {

        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("vehicleModels",vehicleModelService.getVehicleModels());
        model.addAttribute("locations", locationService.getLocations());

        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {

        vehicleService.save(vehicle);

        return "redirect:/vehicles";
    }

    @RequestMapping("/vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id) {

        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicles/updates", method = { RequestMethod.GET, RequestMethod.PUT })
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
