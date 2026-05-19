package com.smarthireai.smarthireai.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String jobTitle;

    private String jobDescription;

    private int minExperience;

    private int maxExperience;

    @ElementCollection
    private List<String> techStack;


    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private float[] embedding;

}