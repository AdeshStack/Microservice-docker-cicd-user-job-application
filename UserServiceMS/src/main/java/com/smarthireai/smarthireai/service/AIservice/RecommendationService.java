package com.smarthireai.smarthireai.service.AIservice;

import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.entity.User;
import com.smarthireai.smarthireai.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private  JobRepository jobRepository;
    private final JobMatchingAIService aiService;

    public List<Job> recommendJobs(User user) {

        List<Job> jobs = jobRepository.findAll();
        List<Job> recommended = new ArrayList<>();

        for (Job job : jobs) {

            String match = aiService.calculateMatch(user, job);

            double percentage = Double.parseDouble(match.replace("%","").trim());

            if (percentage >= 65) {
                recommended.add(job);
            }
        }

        return recommended;
    }
}