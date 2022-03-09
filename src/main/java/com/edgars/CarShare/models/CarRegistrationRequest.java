package com.edgars.CarShare.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class CarRegistrationRequest {
    @Getter
    @Setter
    private Long carId;
    @Getter @Setter
    private Long userId;
    @Getter @Setter
    private LocalDate startingDate;
    @Getter @Setter
    private LocalDate endingDate;

    public CarRegistrationRequest(Long carId, Long userId, LocalDate startingDate, LocalDate endingDate) {
        this.carId = carId;
        this.userId = userId;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }
}
