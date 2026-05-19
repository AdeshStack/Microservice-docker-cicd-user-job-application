package com.smarthireai.smarthireai.service.impl;

import com.smarthireai.smarthireai.dto.UserDto;
import com.smarthireai.smarthireai.entity.User;
import com.smarthireai.smarthireai.repository.UserRepository;
import com.smarthireai.smarthireai.service.AIservice.EmbededService.EmbeddingService;
import com.smarthireai.smarthireai.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.smarthireai.smarthireai.mapper.CustomMapper.mapUser;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmbeddingService embeddingService;

    public UserServiceImpl(UserRepository userRepository, EmbeddingService embeddingService) {
        this.userRepository = userRepository;
        this.embeddingService = embeddingService;
    }

    @Override
    public UserDto createUser(User user) {

        String skillText = String.join(" ", user.getSkills()); // convert into  single string
        float[] embedding = embeddingService.createEmbedding(skillText);
        user.setEmbedding(embedding);
        return mapUser(userRepository.save(user));
    }

    @Override
    public UserDto getUser(Long id) {
        return mapUser(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users=userRepository.findAll();
        List<UserDto> userDtos =users.stream().map(user->mapUser(user)).collect(Collectors.toList());
        return  userDtos;

    }

    @Override
    public UserDto updateUser(Long id, User user) {

        User existing = userRepository.findById(id).orElseThrow();

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());
        existing.setLinkedinUrl(user.getLinkedinUrl());
        existing.setGithubUrl(user.getGithubUrl());
        existing.setYearsOfExperience(user.getYearsOfExperience());
        existing.setSkills(user.getSkills());

        return mapUser(userRepository.save(existing));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
