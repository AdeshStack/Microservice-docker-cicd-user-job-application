package com.smarthireai.smarthireai.EventDrivenUsingKafka.event;

public class JobApplicationFailedEvent {
    private Long userId;
    private Long jobId;
    private String reason;
}