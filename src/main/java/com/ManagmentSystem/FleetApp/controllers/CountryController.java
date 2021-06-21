package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    // returns all the Countries to the HTML file
    @GetMapping("/countries")
    public String getCountries(Model model) {
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("countries", countryList);

        return "country";
    }

    @PostMapping("/countries/addNew")
    public String addNew(Country country) {

        countryService.save(country);

        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(Integer id) {

        return countryService.findById(id);
    }

    @RequestMapping(value = "/countries/updates", method = { RequestMethod.GET, RequestMethod.PUT })
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        countryService.delete(id);
        return "redirect:/countries";
    }

}
