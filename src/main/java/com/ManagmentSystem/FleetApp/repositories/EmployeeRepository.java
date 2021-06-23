package com.ManagmentSystem.FleetApp.repositories;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String un);
}
