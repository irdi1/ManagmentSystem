package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Supplier;
import com.ManagmentSystem.FleetApp.repositories.ClientRepository;
import com.ManagmentSystem.FleetApp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Return list of Clients
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    //Save new Clients
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    //Find Supplier by Id
    public Optional<Supplier> findById(Integer id) {
        return supplierRepository.findById(id);
    }

    //Delete by Supplier id
    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }

}
