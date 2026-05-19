package com.smarthireai.smarthireai.ExternalAPi;

import com.smarthireai.smarthireai.entity.Job;

import com.smarthireai.smarthireai.fallbackcall.FeignConfig;

import com.smarthireai.smarthireai.fallbackcall.JobClientFallback;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@FeignClient(name = "job-service"
)
public interface JobClient {

    @GetMapping("/api/v2/jobs/allJobs")
    List<Job> getAllJobs();


}

