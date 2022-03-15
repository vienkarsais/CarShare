package com.edgars.CarShare.models;

import com.edgars.CarShare.enums.FuelType;
import com.edgars.CarShare.enums.Gearbox;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @NotBlank
    @Getter @Setter
    private String maker;
    @NotBlank
    @Getter @Setter
    private String model;
    @Getter @Setter
    @Min(value = 1970, message = "Made year from 1970")
    private Integer yearMade;
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    private Gearbox gearbox;
    @Min(value = 1, message = "There should be at least drivers seat ;)")
    @Getter @Setter
    private Integer seats;
    @Getter @Setter
    @Min(value = 0, message = "only positive number")
    private Integer priceFor1H;
    @Getter @Setter
    @Min(value = 0, message = "only positive number")
    private Integer priceFor24h;
    @Getter @Setter
    private String imageUrl;

    public Car(String maker, String model, Integer yearMade,
               FuelType fuelType, Gearbox gearbox, Integer seats,
               Integer priceFor1H, Integer priceFor24h, String imageUrl) {
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
