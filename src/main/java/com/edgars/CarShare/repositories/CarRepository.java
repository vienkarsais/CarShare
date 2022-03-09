package com.edgars.CarShare.repositories;

import com.edgars.CarShare.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMaker(String maker);
    List<Car> findByGearbox(String gearbox);
    List<Car> findByFuelType(String fuelType);
}
