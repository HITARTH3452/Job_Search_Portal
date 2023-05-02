package com.example.Job_Search_Portal.controller;

import com.example.Job_Search_Portal.models.Jobs;
import com.example.Job_Search_Portal.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(value = "/getAll")
    public Iterable<Jobs> getJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping(value = "/{id}")
    public Jobs getJobsById(@PathVariable Integer id){
        return jobService.fetchJobById(id);
    }

    @GetMapping(value = "/getAbove/{salary}")
    public List<Jobs> getJobAbove(@PathVariable Double salary){
        return jobService.getJobAboveAmount(salary);
    }

    @PostMapping(value = "/adduser")
    public String insertJobs(@RequestBody List<Jobs> joblist){
        return jobService.addJob(joblist);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteJobById(@PathVariable Integer id){
        return jobService.removeJobById(id);
    }

    @GetMapping(value = "/{title}")
    public List<Jobs> getJobByTitle(@PathVariable String title){
        return jobService.getJobByTitle(title);
    }

    @GetMapping(value = "/{location}")
    public List<Jobs> getJobByLocation(@PathVariable String location){
        return jobService.getJobByLocation(location);
    }

    @GetMapping(value = "/{jobType}")
    public List<Jobs> getJobByJobType(@PathVariable String jobType){
        return jobService.getJobByJobType(jobType);
    }

    @GetMapping(value = "/salary/{salary}")
    public List<Jobs> getJobByAboveSalary(@PathVariable Double salary){
        return jobService.fetchJobByAboveSalary(salary);
    }

    @GetMapping(value = "/jobSort/salary")
    public List<Jobs> getJobSorted(@PathVariable Double salary){
        return jobService.getAllJobsSorted(salary);
    }

}
