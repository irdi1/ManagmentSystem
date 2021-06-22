package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Location;
import com.ManagmentSystem.FleetApp.models.VehicleMake;
import com.ManagmentSystem.FleetApp.repositories.LocationRepository;
import com.ManagmentSystem.FleetApp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    // Return list of states
    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    //Save new Location
    public void  save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    //Find Location by Id
    public Optional<VehicleMake> findById(Integer id) {
        return vehicleMakeRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
