package com.edgars.CarShare.models;

import com.edgars.CarShare.validators.EmailConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Slf4j
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    @NotNull
    @Column(unique = true)
    @EmailConstraint
    private String email;
    @Setter @Getter
    @NotNull
    private String password;
    @Setter @Getter
    private String licenceNumber;
    @Setter @Getter
    private Integer phoneNumber;

    public User(String name, String email, String password, String licenceNumber, Integer phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.licenceNumber = licenceNumber;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }
}
