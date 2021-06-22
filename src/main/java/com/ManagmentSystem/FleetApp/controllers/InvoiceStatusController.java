package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.InvoiceStatus;
import com.ManagmentSystem.FleetApp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    // Get all the JobTitles
    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatuses(Model model) {
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        return "invoiceStatus";
    }

    // Add JobTitles
    @PostMapping(value = "/invoiceStatuses/addNew")
    public String addNew(InvoiceStatus invoiceStatuses) {

        invoiceStatusService.save(invoiceStatuses);

        return "redirect:/invoiceStatuses";
    }

    @RequestMapping("/invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id) {

        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoiceStatuses/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatuses) {
        invoiceStatusService.save(invoiceStatuses);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/deletes", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String update(Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
