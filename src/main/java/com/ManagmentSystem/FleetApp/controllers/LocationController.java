package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.Location;
import com.ManagmentSystem.FleetApp.models.State;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.LocationService;
import com.ManagmentSystem.FleetApp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired private LocationService locationService;
    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    // Get all the States
    @GetMapping("/locations")
    public String getStates(Model model) {
        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList );
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        return "location";
    }

    // Add State
    @PostMapping(value = "/locations/addNew")
    public String addNew(Location location) {

        locationService.save(location);

        return "redirect:/locations";
    }

    @RequestMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id) {

        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
