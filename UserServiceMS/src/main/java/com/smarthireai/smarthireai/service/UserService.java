package com.smarthireai.smarthireai.service;

import com.smarthireai.smarthireai.dto.UserDto;
import com.smarthireai.smarthireai.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(User user);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, User user);

    void deleteUser(Long id);
}