package com.edgars.CarShare.models;

import com.edgars.CarShare.enums.FuelType;
import com.edgars.CarShare.enums.Gearbox;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    @NotBlank
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    private Gearbox gearbox;
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

    public Car(String maker, String model, Integer yearMade, FuelType fuelType, Gearbox gearbox, Integer seats, Integer priceFor1H, Integer priceFor24h, String imageUrl) {
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
