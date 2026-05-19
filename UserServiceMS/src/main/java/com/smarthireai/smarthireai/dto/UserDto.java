package com.smarthireai.smarthireai.dto;

import jakarta.persistence.ElementCollection;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder

public class UserDto {

    private String name;

    private String email;

    private String phone;

    private String linkedinUrl;

    private String githubUrl;

    private int yearsOfExperience;

    private String location;

    private String currentCompany;

    private String education;


    private List<String> skills;
}
