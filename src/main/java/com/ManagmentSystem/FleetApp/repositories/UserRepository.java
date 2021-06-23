package com.ManagmentSystem.FleetApp.repositories;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);

}
