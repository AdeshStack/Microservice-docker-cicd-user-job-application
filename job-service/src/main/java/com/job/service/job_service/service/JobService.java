package com.job.service.job_service.service;


import com.job.service.job_service.dto.JobDto;
import com.job.service.job_service.entity.Job;

import java.util.List;

public interface JobService {

    JobDto createJob(Job job);

    JobDto getJob(Long id);

    List<JobDto> getAllJobs();

    JobDto updateJob(Long id, Job job);

    void deleteJob(Long id);
}