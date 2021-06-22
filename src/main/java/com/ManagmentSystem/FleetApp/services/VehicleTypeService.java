package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Location;
import com.ManagmentSystem.FleetApp.models.VehicleType;
import com.ManagmentSystem.FleetApp.repositories.LocationRepository;
import com.ManagmentSystem.FleetApp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    // Return list of states
    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    //Save new Location
    public void  save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    //Find Location by Id
    public Optional<VehicleType> findById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
