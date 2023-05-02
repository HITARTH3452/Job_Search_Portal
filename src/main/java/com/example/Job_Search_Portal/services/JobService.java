package com.example.Job_Search_Portal.services;

import com.example.Job_Search_Portal.models.Jobs;
import com.example.Job_Search_Portal.repository.IjobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IjobRepo jobRepo;

    public Iterable<Jobs> getAllJobs() {
        Iterable<Jobs> allJobs = jobRepo.findAll();
        return allJobs;
    }

    public Jobs fetchJobById(Integer id) {
        return jobRepo.findById(id).get();
    }

    public String addJob(Iterable<Jobs> joblist) {
        Iterable<Jobs> addedJobs = jobRepo.saveAll(joblist);
        if(addedJobs != null) return "Yes";
        else return "No";
    }

    public String removeJobById(Integer id) {

        jobRepo.deleteById(id);
        return "deleted";
    }

    public List<Jobs> getJobByTitle(String title) {
        return jobRepo.findByTitle(title);
    }

    public List<Jobs> getJobByLocation(String location) {
        return jobRepo.findByLocation(location);
    }

    public List<Jobs> getJobByJobType(String jobType) {
        return  jobRepo.findByJobType(jobType);
    }

    public List<Jobs> fetchJobByAboveSalary(Double salary) {
        return jobRepo.findBySalaryGreaterThan(salary);
    }

    public List<Jobs> getAllJobsSorted(Double salary) {
        return jobRepo.findJobsOrderedBySalarybSorted(salary);
    }

    public List<Jobs> getJobAboveAmount(Double salary) {
        return jobRepo.findJobsAboveAmount(salary);
    }
}
