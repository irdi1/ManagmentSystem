package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.VehicleHire;
import com.ManagmentSystem.FleetApp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    // Return list of VehicleHires
    public List<VehicleHire> getVehicleHires() {
        return vehicleHireRepository.findAll();
    }

    //Save new VehicleHires
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    //Find VehicleHire by Id
    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireRepository.findById(id);
    }

    //Delete by VehicleHire id
    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
