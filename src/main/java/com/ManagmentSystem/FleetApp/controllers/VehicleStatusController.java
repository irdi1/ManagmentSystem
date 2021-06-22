package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.VehicleModel;
import com.ManagmentSystem.FleetApp.models.VehicleStatus;
import com.ManagmentSystem.FleetApp.repositories.VehicleStatusRepository;
import com.ManagmentSystem.FleetApp.services.VehicleStatusService;
import com.ManagmentSystem.FleetApp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    // Get all the VehicleStatuses
    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses(Model model) {
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatusList);

        return "vehicleStatus";
    }

    // Add VehicleStatuses
    @PostMapping(value = "/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus) {

        vehicleStatusService.save(vehicleStatus);

        return "redirect:/vehicleStatuses";
    }

    @RequestMapping("/vehicleStatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id) {

        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicleStatuses/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }
}
