package com.smarthireai.smarthireai.entity;

import com.smarthireai.smarthireai.validationGroup.create;
import com.smarthireai.smarthireai.validationGroup.update;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = update.class,message = "Id is required!")
    private Long id;

    @NotNull(groups = {update.class, create.class},message = "Name is required")
    private String name;

    private String email;

    private String phone;

    private String linkedinUrl;

    private String githubUrl;

    private int yearsOfExperience;

    private transient String location;

    private String currentCompany;

    private String education;

    @ElementCollection
    private List<String> skills;

    // vector
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private float[] embedding;


}