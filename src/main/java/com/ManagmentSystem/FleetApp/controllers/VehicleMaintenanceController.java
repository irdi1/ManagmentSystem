package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.VehicleMaintenance;
import com.ManagmentSystem.FleetApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired private SupplierService supplierService;
    @Autowired private VehicleMaintenanceService vehicleMaintenanceService;

    // Get all the States
    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model) {
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("suppliers", supplierService.getSuppliers());

        return "vehicleMaintenance";
    }

    // Add State
    @PostMapping(value = "/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {

        vehicleMaintenanceService.save(vehicleMaintenance);

        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("/vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id) {

        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "/vehicleMaintenances/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value = "/vehicleMaintenances/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }

}
