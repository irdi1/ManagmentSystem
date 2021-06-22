package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Location;
import com.ManagmentSystem.FleetApp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Return list of states
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    //Save new Location
    public void  save(Location location) {
        locationRepository.save(location);
    }

    //Find Location by Id
    public Optional<Location> findById(Integer id) {
        return locationRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
