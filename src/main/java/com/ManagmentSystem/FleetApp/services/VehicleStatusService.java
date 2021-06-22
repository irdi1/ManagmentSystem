package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.VehicleStatus;
import com.ManagmentSystem.FleetApp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    // Return list of states
    public List<VehicleStatus> getVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    //Save new Location
    public void  save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    //Find Location by Id
    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
