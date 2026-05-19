package com.smarthireai.smarthireai.fallbackcall;


import com.smarthireai.smarthireai.ExternalAPi.JobClient;
import com.smarthireai.smarthireai.entity.Job;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;



@Component
public class JobClientFallback implements JobClient {

    @Override
    public List<Job> getAllJobs() {
        System.out.println("🔥 FALLBACK HIT 🔥");
        return Collections.emptyList();
    }
}