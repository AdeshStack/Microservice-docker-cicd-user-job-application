package com.smarthireai.smarthireai.EventDrivenUsingKafka.repo;

import com.smarthireai.smarthireai.EventDrivenUsingKafka.entity.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserApplicationRepository extends JpaRepository<UserApplication,Long> {
}
