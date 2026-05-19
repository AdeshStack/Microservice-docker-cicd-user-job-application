package com.job.service.job_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JobDto {
    private String companyName;

    private String jobTitle;

    private String jobDescription;

    private int minExperience;

    private int maxExperience;


    private List<String> techStack;
}
