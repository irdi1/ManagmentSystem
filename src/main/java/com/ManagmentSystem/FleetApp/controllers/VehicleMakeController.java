package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.VehicleMake;
import com.ManagmentSystem.FleetApp.models.State;
import com.ManagmentSystem.FleetApp.models.VehicleMake;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    // Get all the States
    @GetMapping("/vehicleMakers")
    public String getVehicleMakes(Model model) {
        List<VehicleMake> vehicleMakesList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakers", vehicleMakesList);
        return "vehicleMake";
    }

    // Add State
    @PostMapping(value = "/vehicleMakers/addNew")
    public String addNew(VehicleMake vehicleMake) {

        vehicleMakeService.save(vehicleMake);

        return "redirect:/vehicleMakers";
    }

    @RequestMapping("/vehicleMakers/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id) {

        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehicleMakers/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakers";
    }

    @RequestMapping(value = "/vehicleMakers/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakers";
    }
}
