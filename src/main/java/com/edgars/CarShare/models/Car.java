package com.edgars.CarShare.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @NotBlank
    @Range(min = 2)
    @Getter @Setter
    private String maker;
    @NotBlank
    @Getter @Setter
    private String model;
    @NotBlank
    @Getter @Setter
    private Integer yearMade;
    @NotBlank
    @Getter @Setter
    private String fuelType;
    @NotBlank
    @Getter @Setter
    private String gearbox;
    @NotBlank
    @Pattern(regexp = "[0-9]")
    @Getter @Setter
    private Integer seats;
    @Getter @Setter
    private Integer priceFor1H;
    @Getter @Setter
    private Integer priceFor24h;
    @Getter @Setter
    private String imageUrl;

    public Car(String maker, String model, Integer yearMade, String fuelType, String gearbox, Integer seats, Integer priceFor1H, Integer priceFor24h, String imageUrl) {
        this.maker = maker;
        this.model = model;
        this.yearMade = yearMade;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.seats = seats;
        this.priceFor1H = priceFor1H;
        this.priceFor24h = priceFor24h;
        this.imageUrl = imageUrl;
    }

    public Car() {
    }
}
