package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.State;
import com.ManagmentSystem.FleetApp.services.ClientService;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ClientService clientService;

    // Get all the States
    @GetMapping("/clients")
    public String getStates(Model model) {
        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());

        return "client";
    }

    // Add State
    @PostMapping(value = "/clients/addNew")
    public String addNew(Client client) {

        clientService.save(client);

        return "redirect:/clients";
    }

    @RequestMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id) {

        return clientService.findById(id);
    }

    @RequestMapping(value = "/clients/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }

}
