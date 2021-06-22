package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Supplier;
import com.ManagmentSystem.FleetApp.services.ClientService;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.StateService;
import com.ManagmentSystem.FleetApp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired private SupplierService supplierService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    // Get all the States
    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("countries", countryService.getCountries());

        return "supplier";
    }

    // Add State
    @PostMapping(value = "/suppliers/addNew")
    public String addNew(Supplier supplier) {

        supplierService.save(supplier);

        return "redirect:/suppliers";
    }

    @RequestMapping("/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id) {

        return supplierService.findById(id);
    }

    @RequestMapping(value = "/suppliers/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
