package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.InvoiceStatus;
import com.ManagmentSystem.FleetApp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    // Return list of states
    public List<InvoiceStatus> getInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    //Save new Location
    public void  save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    //Find Location by Id
    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
