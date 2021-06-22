package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.VehicleModel;
import com.ManagmentSystem.FleetApp.models.VehicleType;
import com.ManagmentSystem.FleetApp.repositories.VehicleModelRepository;
import com.ManagmentSystem.FleetApp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    // Return list of states
    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    //Save new Location
    public void  save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    //Find Location by Id
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
