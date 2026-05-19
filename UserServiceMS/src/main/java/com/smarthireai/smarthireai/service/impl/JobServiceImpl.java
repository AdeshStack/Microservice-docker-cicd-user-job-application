package com.smarthireai.smarthireai.service.impl;

import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.repository.JobRepository;
import com.smarthireai.smarthireai.service.AIservice.EmbededService.EmbeddingService;
import com.smarthireai.smarthireai.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.smarthireai.smarthireai.mapper.CustomMapper.mapJob;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final EmbeddingService embeddingService;

    public JobServiceImpl(JobRepository jobRepository, EmbeddingService embeddingService) {
        this.jobRepository = jobRepository;
        this.embeddingService = embeddingService;
    }

    @Override
    public JobDto createJob(Job job) {
//        return jobRepository.save(job);
        String techText = String.join(" ", job.getTechStack());

        float[] embedding = embeddingService.createEmbedding(techText);

        job.setEmbedding(embedding);

        return mapJob( jobRepository.save(job));
    }

    @Override
    public JobDto getJob(Long id) {
        return mapJob(jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found")));
    }

    @Override
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll().stream().map(job->mapJob(job)).collect(Collectors.toList());
    }

    @Override
    public JobDto updateJob(Long id, Job job) {

        Job existing = jobRepository.findById(id).orElseThrow();

        existing.setCompanyName(job.getCompanyName());
        existing.setJobTitle(job.getJobTitle());
        existing.setJobDescription(job.getJobDescription());
        existing.setMinExperience(job.getMinExperience());
        existing.setMaxExperience(job.getMaxExperience());
        existing.setTechStack(job.getTechStack());

        return mapJob(jobRepository.save(existing));
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}