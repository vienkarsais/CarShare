package com.edgars.CarShare.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class CarRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Getter @Setter
    private LocalDate startingDate;
    @Getter @Setter
    private LocalDate endingDate;

    public CarRegistration(Car car, User user, LocalDate startingDate, LocalDate endingDate) {
        this.car = car;
        this.user = user;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public CarRegistration() {
    }
}
