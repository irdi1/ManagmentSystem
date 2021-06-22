package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.models.Vehicle;
import com.ManagmentSystem.FleetApp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    //Save new Clients
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    //Find Client by Id
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }

    //Delete by Client id
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
