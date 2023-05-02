package com.example.Job_Search_Portal.repository;

import com.example.Job_Search_Portal.models.Jobs;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IjobRepo extends CrudRepository<Jobs,Integer> {

    public List<Jobs> findByTitle(String title);

    public List<Jobs> findByLocation(String location);

    public List<Jobs> findByJobType(String jobType);

    public List<Jobs> findBySalaryGreaterThan(Double salary);

    @Query(value = "select * from jobs order by salary", nativeQuery = true)
    public List<Jobs> findJobsOrderedBySalarybSorted(Double salary);

    @Query(value = "select * from jobs where salary > amount" , nativeQuery = true)
    public List<Jobs> findJobsAboveAmount(Double amount);

}
