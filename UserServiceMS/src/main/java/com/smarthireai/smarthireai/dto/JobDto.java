package com.smarthireai.smarthireai.dto;

import jakarta.persistence.ElementCollection;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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
