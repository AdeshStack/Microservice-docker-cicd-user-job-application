package com.job.service.job_service.Mapper;


import com.job.service.job_service.dto.JobDto;
import com.job.service.job_service.entity.Job;

public class CustomMapper {

//    public static UserDto mapUser(User user){
//
//        UserDto userDto = UserDto.builder()
//                .name(user.getName())
//                .email(user.getEmail())
//                .phone(user.getPhone())
//                .linkedinUrl(user.getLinkedinUrl())
//                .githubUrl(user.getGithubUrl())
//                .yearsOfExperience(user.getYearsOfExperience())
//                .location(user.getLocation())
//                .currentCompany(user.getCurrentCompany())
//                .education(user.getEducation())
//                .skills(user.getSkills())
//                .build();
//        return userDto;
//    }

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
