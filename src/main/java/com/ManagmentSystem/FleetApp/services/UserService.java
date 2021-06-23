package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.User;
import com.ManagmentSystem.FleetApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
