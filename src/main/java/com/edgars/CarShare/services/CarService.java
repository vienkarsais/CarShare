package com.edgars.CarShare.services;

import com.edgars.CarShare.models.Car;

import java.util.List;

public interface CarService {
    Car addCar(Car car);
    Car updateCar(Car car);
    List<Car> showAllCars();
    Car findCarById(Long id);
    void deleteCar(Long id);
    void deleteAllCars();
    List<Car> findCarByMaker(String maker);
    List<Car> findCarByGearbox(String gearbox);
    List<Car> findCarByFuelType(String fuelType);
}
