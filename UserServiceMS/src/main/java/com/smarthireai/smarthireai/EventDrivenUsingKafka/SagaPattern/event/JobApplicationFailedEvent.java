package com.smarthireai.smarthireai.EventDrivenUsingKafka.SagaPattern.event;

public class JobApplicationFailedEvent {
    private Long userId;
    private Long jobId;
    private String reason;
}