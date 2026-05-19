package com.smarthireai.smarthireai.EventDrivenUsingKafka.event;

public class JobAppliedEvent {
    private Long userId;
    private Long jobId;
    private String status;

    public JobAppliedEvent() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}