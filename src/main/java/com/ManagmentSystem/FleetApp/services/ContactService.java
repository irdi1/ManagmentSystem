package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.Contact;
import com.ManagmentSystem.FleetApp.models.Contact;
import com.ManagmentSystem.FleetApp.repositories.ClientRepository;
import com.ManagmentSystem.FleetApp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Return list of Clients
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    //Save new Clients
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    //Find Contact by Id
    public Optional<Contact> findById(Integer id) {
        return contactRepository.findById(id);
    }

    //Delete by Contact id
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }


}
