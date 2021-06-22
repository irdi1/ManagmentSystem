package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Client;
import com.ManagmentSystem.FleetApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Return list of Clients
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //Save new Clients
    public void save(Client client) {
        clientRepository.save(client);
    }

    //Find Client by Id
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    //Delete by Client id
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

}
