package com.example.Job_Search_Portal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs")
@Entity
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotBlank
    private String title;
    private String description;
    private String location;
    @Column(name = "salary")
    private Double salary;
    private String companyName;
    private String employerName;
    private String jobType;
}
