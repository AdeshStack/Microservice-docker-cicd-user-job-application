package com.smarthireai.smarthireai.controller;

import com.smarthireai.smarthireai.dto.JobDto;
import com.smarthireai.smarthireai.dto.UserDto;
import com.smarthireai.smarthireai.entity.Job;
import com.smarthireai.smarthireai.entity.User;
import com.smarthireai.smarthireai.repository.UserRepository;
import com.smarthireai.smarthireai.service.AIservice.EmbededService.RecommendationServiceusingEmbeded;
import com.smarthireai.smarthireai.service.AIservice.RecommendationService;
import com.smarthireai.smarthireai.service.UserService;
import com.smarthireai.smarthireai.validationGroup.create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
@Validated // -> for path-variable validation
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommendationServiceusingEmbeded recommendationServiceusingEmbeded;

    @PostMapping
    public ResponseEntity<UserDto> Create(@Validated(create.class) @RequestBody User user){

        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> GetAll(){
        return new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);
    }

//    // Job recommendation service // without embeded system
//    @GetMapping("/recommend/{userId}")
//    public ResponseEntity<List<JobDto>> RecommendJobs(@PathVariable("userId") Long userId){
//
//        User user=this.userRepository.findById(userId).orElseThrow();
//        return new ResponseEntity<>(recommendationService.recommendJobs(user),HttpStatus.OK);
//    }

    //using embeded system
    @GetMapping("/recommend2/{userId}") // pathvariable
    public ResponseEntity<List<JobDto>> RecommendJobs2(@PathVariable("userId") @Min(value = 1,message = "value will be more than 1") Long userId){

        if(userId==0){
             throw new  RuntimeException("Invalid Id");
        }
        User user=this.userRepository.findById(userId).orElseThrow();
        return new ResponseEntity<>(recommendationServiceusingEmbeded.recommendJobs(user),HttpStatus.OK);
    }

    // handling exception in for this controller

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String>handleException(RuntimeException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    // doing pagination
    @GetMapping("/users")
    public Page<User> getUsers(
            @RequestParam int page, // which page number
            @RequestParam int size) { // total page

        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }
    @GetMapping("/users/sort")
    public List<User> getUsersSorted() {

        Sort sort = Sort.by("name").ascending();

        return userRepository.findAll(sort);
    }

}
