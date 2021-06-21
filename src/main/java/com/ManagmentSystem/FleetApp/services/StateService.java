package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.State;

import com.ManagmentSystem.FleetApp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    // Return list of states
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    //Save new State
    public void  save(State state) {
        stateRepository.save(state);
    }

    //Find State by Id
    public Optional<State> findById(Integer id) {
        return stateRepository.findById(id);
    }

    //Delete by State id
    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
