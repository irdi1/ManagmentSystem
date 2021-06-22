package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.VehicleHire;
import com.ManagmentSystem.FleetApp.services.ClientService;
import com.ManagmentSystem.FleetApp.services.VehicleHireService;
import com.ManagmentSystem.FleetApp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired private VehicleHireService vehicleHireService;
    @Autowired private ClientService clientService;
    @Autowired private VehicleService vehicleService;


    // returns all the Countries to the HTML file
    @GetMapping("/vehicleHires")
    public String getVehicleHire(Model model) {

        model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire) {

        vehicleHireService.save(vehicleHire);

        return "redirect:/vehicleHires";
    }

    @RequestMapping("/vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id) {

        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/updates", method = { RequestMethod.GET, RequestMethod.PUT })
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
