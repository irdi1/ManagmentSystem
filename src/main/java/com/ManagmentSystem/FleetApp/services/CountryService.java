package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Country;
import com.ManagmentSystem.FleetApp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //Save new Country
    public void  save(Country country) {
        countryRepository.save(country);
    }

    //Find country by Id
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    //Delete by Country id
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

}
