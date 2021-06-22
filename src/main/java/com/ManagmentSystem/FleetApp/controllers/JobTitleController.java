package com.ManagmentSystem.FleetApp.controllers;

import com.ManagmentSystem.FleetApp.models.JobTitle;
import com.ManagmentSystem.FleetApp.services.JobTitleService;
import com.ManagmentSystem.FleetApp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    // Get all the JobTitles
    @GetMapping("/jobTitles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        return "jobTitle";
    }

    // Add JobTitles
    @PostMapping(value = "/jobTitles/addNew")
    public String addNew(JobTitle jobTitles) {

        jobTitleService.save(jobTitles);

        return "redirect:/jobTitles";
    }

    @RequestMapping("/jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id) {

        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/jobTitles/updates", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitles) {
        jobTitleService.save(jobTitles);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/deletes", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String update(Integer id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
