package com.edgars.CarShare.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String email;
    @Setter @Getter
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
