package com.smarthireai.smarthireai.controller;


import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("api/v2/jobs")
//public class JobController {
//
//    @Autowired
//    private JobService jobService;
//
//    @PostMapping
//    public ResponseEntity<JobDto> Create(@RequestBody Job job){
//        return new ResponseEntity(this.jobService.createJob(job), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<JobDto>> GetAll(){
//        return new ResponseEntity<>(this.jobService.getAllJobs(),HttpStatus.OK);
//    }
//
//
//}
