package com.ManagmentSystem.FleetApp.repositories;

import com.ManagmentSystem.FleetApp.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
}
