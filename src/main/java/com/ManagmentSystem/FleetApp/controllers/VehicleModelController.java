package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.VehicleModel;
import com.ManagmentSystem.FleetApp.models.State;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    // Get all the VehicleModels
    @GetMapping("/vehicleModels")
    public String getVehicleModels(Model model) {
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelList);

        return "vehicleModel";
    }

    // Add VehicleModels
    @PostMapping(value = "/vehicleModels/addNew")
    public String addNew(VehicleModel vehicleModel) {

        vehicleModelService.save(vehicleModel);

        return "redirect:/vehicleModels";
    }

    @RequestMapping("/vehicleModels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id) {

        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehicleModels/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/vehicleModels/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
