package com.smarthireai.smarthireai.service.AIservice.EmbededService;

import com.smarthireai.smarthireai.ExternalAPi.JobClient;
import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.entity.User;
import com.smarthireai.smarthireai.repository.JobRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.smarthireai.smarthireai.mapper.CustomMapper.mapJob;

@Service
public class RecommendationServiceusingEmbeded {

    private final JobRepository jobRepository;


    public JobClient jobClient;

    public RecommendationServiceusingEmbeded(JobRepository jobRepository,JobClient jobClient) {
        this.jobRepository = jobRepository;
        this.jobClient=jobClient;
    }

//    @Bulkhead(name = "job-service", fallbackMethod = "fallbackRecommendJobs")
//    @Retry(name = "job-service", fallbackMethod = "fallbackRecommendJobs") //👉 Handles temporary failures , like network glitch or db load
    @CircuitBreaker(name = "job-service", fallbackMethod = "fallbackRecommendJobs")
    @RateLimiter(name = "job-service", fallbackMethod = "fallbackRecommendJobs")
    public List<JobDto> recommendJobs(User user){
// api for all jobs
//        List<Job> jobs = jobRepository.findAll();-> monolithic
        // from diff MS
        // calling it using feign client
        List<Job> jobs=jobClient.getAllJobs();

        List<JobDto> recommended = new ArrayList<>();

        for(Job job : jobs){

            double score = cosineSimilarity(
                    user.getEmbedding(),
                    job.getEmbedding()
            );

            if(score >= 0.70){
                recommended.add(mapJob(job));
            }
        }

        return recommended;
    }

    // 🔥 FALLBACK METHOD
    public List<JobDto> fallbackRecommendJobs(User user, Throwable e){
        System.out.println("🔥 FALLBACK TRIGGERED: " + e.getMessage());

        // fallback logic (empty / cached / default)
        return new ArrayList<>();
    }

    private double cosineSimilarity(float[] vec1, float[] vec2){

        double dot = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for(int i = 0; i < vec1.length; i++){
            dot += vec1[i] * vec2[i];
            normA += Math.pow(vec1[i],2);
            normB += Math.pow(vec2[i],2);
        }

        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}