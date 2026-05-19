package com.job.service.job_service.EventDrivenUsingKafka.SagaPattern.event;

public class JobApplicationFailedEvent {
    private Long userId;
    private Long jobId;
    private String reason;
}