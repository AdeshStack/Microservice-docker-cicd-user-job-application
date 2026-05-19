package com.job.service.job_service.EventDrivenUsingKafka.service;

import com.job.service.job_service.EventDrivenUsingKafka.entity.JobApplication;
import com.job.service.job_service.EventDrivenUsingKafka.event.JobAppliedEvent;
import com.job.service.job_service.EventDrivenUsingKafka.repo.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private JobApplicationRepository repository;

    @KafkaListener(topics = "job-applied-topic1", groupId = "job-group")
    public void consume(JobAppliedEvent event) {

        System.out.println("****Received event****");
        System.out.println("ID of the applicant-> "+event.getUserId());
//
//        // Save in DB
//        JobApplication app = new JobApplication();
//        app.setUserId(event.getUserId());
//        app.setJobId(event.getJobId());

//        repository.save(app);
    }
}