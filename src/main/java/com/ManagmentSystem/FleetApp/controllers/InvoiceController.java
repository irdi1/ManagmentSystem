package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.models.Invoice;
import com.ManagmentSystem.FleetApp.models.InvoiceStatus;
import com.ManagmentSystem.FleetApp.services.ClientService;
import com.ManagmentSystem.FleetApp.services.InvoiceStatusService;
import com.ManagmentSystem.FleetApp.services.InvoiceService;
import com.ManagmentSystem.FleetApp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {


    @Autowired private InvoiceService invoiceService;
    @Autowired private InvoiceStatusService invoiceStatusService;
    @Autowired private ClientService clientService;

    // Get all the States
    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        model.addAttribute("invoices", invoiceService.getInvoices());

        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());

        model.addAttribute("clients", clientService.getClients());
        return "invoice";
    }

    // Add Invoice
    @PostMapping(value = "/invoices/addNew")
    public String addNew(Invoice invoice) {

        invoiceService.save(invoice);

        return "redirect:/invoices";
    }

    @RequestMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id) {

        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
