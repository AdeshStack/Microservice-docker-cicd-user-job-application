package com.smarthireai.smarthireai.mapper;

import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.dto.UserDto;
import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.entity.User;

public class CustomMapper {

    public static UserDto mapUser(User user){

        UserDto userDto = UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .linkedinUrl(user.getLinkedinUrl())
                .githubUrl(user.getGithubUrl())
                .yearsOfExperience(user.getYearsOfExperience())
                .location(user.getLocation())
                .currentCompany(user.getCurrentCompany())
                .education(user.getEducation())
                .skills(user.getSkills())
                .build();
        return userDto;
    }

    public  static JobDto mapJob(Job job){
        return JobDto.builder()
                .companyName(job.getCompanyName())
                .jobTitle(job.getJobTitle())
                .jobDescription(job.getJobDescription())
                .minExperience(job.getMinExperience())
                .maxExperience(job.getMaxExperience())
                .techStack(job.getTechStack())
                .build();
    }
}
