package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.VehicleMaintenance;
import com.ManagmentSystem.FleetApp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    // Return list of Clients
    public List<VehicleMaintenance> getVehicleMaintenances() {
        return vehicleMaintenanceRepository.findAll();
    }

    //Save new Clients
    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    //Find VehicleMaintenance by Id
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    //Delete by VehicleMaintenance id
    public void delete(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }

}
