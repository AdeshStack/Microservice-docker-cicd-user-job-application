package com.smarthireai.smarthireai.repository;

import com.smarthireai.smarthireai.Projections.UserView;
import com.smarthireai.smarthireai.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<User,Long> {

    Page<User> findAll(Pageable pageable);

    @Query("SELECT u.name AS name, u.email AS email FROM User u")
    List<UserView> findUserDetails();  //few detail will be fetched
}