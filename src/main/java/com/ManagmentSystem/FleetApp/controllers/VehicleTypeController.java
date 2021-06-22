package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.VehicleType;
import com.ManagmentSystem.FleetApp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    // Get all the VehicleTypes
    @GetMapping("/vehicleTypes")
    public String getVehicleTypes(Model model) {
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypeList);

        return "vehicleType";
    }

    // Add VehicleTypes
    @PostMapping(value = "/vehicleTypes/addNew")
    public String addNew(VehicleType vehicleType) {

        vehicleTypeService.save(vehicleType);

        return "redirect:/vehicleTypes";
    }

    @RequestMapping("/vehicleTypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id) {

        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicleTypes/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
