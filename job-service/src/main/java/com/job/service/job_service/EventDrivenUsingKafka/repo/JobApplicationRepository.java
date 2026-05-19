package com.job.service.job_service.EventDrivenUsingKafka.repo;

import com.job.service.job_service.EventDrivenUsingKafka.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
}
