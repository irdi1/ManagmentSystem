package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Invoice;
import com.ManagmentSystem.FleetApp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Return list of states
    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    //Save new State
    public void  save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    //Find State by Id
    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    //Delete by State id
    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
