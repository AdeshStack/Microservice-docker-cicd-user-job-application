package com.job.service.job_service.repository;


import com.job.service.job_service.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository
        extends JpaRepository<Job,Long> {
}