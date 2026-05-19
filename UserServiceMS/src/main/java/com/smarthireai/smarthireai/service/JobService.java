package com.smarthireai.smarthireai.service;

import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.entity.Job;

import java.util.List;

public interface JobService {

    JobDto createJob(Job job);

    JobDto getJob(Long id);

    List<JobDto> getAllJobs();

    JobDto updateJob(Long id, Job job);

    void deleteJob(Long id);
}