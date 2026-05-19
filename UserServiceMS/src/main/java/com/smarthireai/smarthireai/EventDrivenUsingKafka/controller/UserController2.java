package com.smarthireai.smarthireai.EventDrivenUsingKafka.controller;

import com.smarthireai.smarthireai.EventDrivenUsingKafka.entity.UserApplication;
import com.smarthireai.smarthireai.EventDrivenUsingKafka.event.JobAppliedEvent;
import com.smarthireai.smarthireai.EventDrivenUsingKafka.repo.UserApplicationRepository;
import com.smarthireai.smarthireai.EventDrivenUsingKafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/message")
public class UserController2 {

    @Autowired
    private KafkaProducerService producer;

    @Autowired
    private UserApplicationRepository repository;

    @PostMapping("/apply")
    public String apply(@RequestBody JobAppliedEvent event) {

        // Save in DB
        UserApplication app = new UserApplication();
        app.setUserId(event.getUserId());
        app.setJobId(event.getJobId());
        repository.save(app);

        // Send event
        producer.sendEvent(event);

        return "Applied successfully";
    }
}