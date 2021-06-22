package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.VehicleMovement;
import com.ManagmentSystem.FleetApp.repositories.ClientRepository;
import com.ManagmentSystem.FleetApp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    // Return list of VehicleMovements
    public List<VehicleMovement> getVehicleMovements() {
        return vehicleMovementRepository.findAll();
    }

    //Save new VehicleMovements
    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    //Find VehicleMovement by Id
    public Optional<VehicleMovement> findById(Integer id) {
        return vehicleMovementRepository.findById(id);
    }

    //Delete by VehicleMovement id
    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }

}
