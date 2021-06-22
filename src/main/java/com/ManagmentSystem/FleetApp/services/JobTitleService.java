package com.ManagmentSystem.FleetApp.services;

import com.ManagmentSystem.FleetApp.models.JobTitle;
import com.ManagmentSystem.FleetApp.models.JobTitle;
import com.ManagmentSystem.FleetApp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    // Return list of states
    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    //Save new Location
    public void  save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    //Find Location by Id
    public Optional<JobTitle> findById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    //Delete by Location id
    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
