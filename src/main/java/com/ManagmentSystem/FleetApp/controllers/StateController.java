package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.State;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    // Get all the States
    @GetMapping("/states")
    public String getStates(Model model) {
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "state";
    }

    // Add State
    @PostMapping(value = "/states/addNew")
    public String addNew(State state) {

        stateService.save(state);

        return "redirect:/states";
    }

    @RequestMapping("/states/findById")
    @ResponseBody
    public Optional<State> findById(Integer id) {

        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}
