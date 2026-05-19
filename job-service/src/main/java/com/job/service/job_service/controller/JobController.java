package com.job.service.job_service.controller;



import com.job.service.job_service.dto.JobDto;
import com.job.service.job_service.entity.Job;
import com.job.service.job_service.repository.JobRepository;
import com.job.service.job_service.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/jobs")
public class JobController {

    private final Logger logger= LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public ResponseEntity<JobDto> Create(@RequestBody Job job){
        return new ResponseEntity(this.jobService.createJob(job), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> GetAll(){
        return new ResponseEntity<>(this.jobService.getAllJobs(),HttpStatus.OK);
    }


    @GetMapping("/allJobs")
    public ResponseEntity<List<Job>> GetAllJobs(){
        logger.info("****calling Job service from User service****");
        return new ResponseEntity<>(jobRepository.findAll(),HttpStatus.OK);
    }


}
