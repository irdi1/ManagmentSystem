package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.VehicleMovement;
import com.ManagmentSystem.FleetApp.services.LocationService;
import com.ManagmentSystem.FleetApp.services.VehicleMovementService;
import com.ManagmentSystem.FleetApp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleMovementService vehicleMovementService;

    // Get all the VehicleMovements
    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model) {
        model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());

        return "vehicleMovement";
    }

    // Add VehicleMovement
    @PostMapping(value = "/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {

        vehicleMovementService.save(vehicleMovement);

        return "redirect:/vehicleMovements";
    }

    @RequestMapping("/vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id) {

        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovements/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
