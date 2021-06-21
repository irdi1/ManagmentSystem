package com.ManagmentSystem.FleetApp.repositories;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
