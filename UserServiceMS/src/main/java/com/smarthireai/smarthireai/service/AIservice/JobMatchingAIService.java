package com.smarthireai.smarthireai.service.AIservice;

import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.entity.User;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class JobMatchingAIService {

    private final ChatClient chatClient;

    public JobMatchingAIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String calculateMatch(User user, Job job) {

        String prompt = """
        Compare the following user skills and job requirements.

        User Skills: %s
        Job Tech Stack: %s
        User Experience: %d
        Required Experience: %d

        Calculate the skill match percentage.
        Return only the number.
        """.formatted(
                user.getSkills(),
                job.getTechStack(),
                user.getYearsOfExperience(),
                job.getMinExperience()
        );

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}