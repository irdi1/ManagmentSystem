package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.User;
import com.ManagmentSystem.FleetApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired private UserRepository userRepository;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
