package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Contact;
import com.ManagmentSystem.FleetApp.services.ContactService;
import com.ManagmentSystem.FleetApp.services.CountryService;
import com.ManagmentSystem.FleetApp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ContactService contactService;

    // Get all the States
    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("contacts", contactService.getContacts());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());

        return "contact";
    }

    // Add State
    @PostMapping(value = "/contacts/addNew")
    public String addNew(Contact contact) {

        contactService.save(contact);

        return "redirect:/contacts";
    }

    @RequestMapping("/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id) {

        return contactService.findById(id);
    }

    @RequestMapping(value = "/contacts/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
