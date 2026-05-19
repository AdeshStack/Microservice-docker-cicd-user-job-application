package com.smarthireai.smarthireai.EventDrivenUsingKafka.service;

import com.smarthireai.smarthireai.EventDrivenUsingKafka.event.JobAppliedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, JobAppliedEvent> kafkaTemplate; //KafkaTemplate is a Spring Kafka helper class used to send messages to Kafka.

    public void sendEvent(JobAppliedEvent event) {
        kafkaTemplate.send("job-applied-topic1", event);
    }//Sends the event to Kafka topic → "job-applied-topic" //A topic = place where messages live
}