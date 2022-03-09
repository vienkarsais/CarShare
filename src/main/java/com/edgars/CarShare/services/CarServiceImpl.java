package com.edgars.CarShare.services;

import com.edgars.CarShare.exceptions.CarNotFoundException;
import com.edgars.CarShare.models.Car;
import com.edgars.CarShare.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }
    public Car updateCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> showAllCars(){
        return carRepository.findAll();
    }

    public Car findCarById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car by id: " + id + " not found"));
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
    public void deleteAllCars(){
        carRepository.deleteAll();
    }
    public List<Car> findCarByMaker(String maker){
        return carRepository.findByMaker(maker);
    }
    public List<Car> findCarByGearbox(String gearbox){
        return carRepository.findByGearbox(gearbox);
    }
    public List<Car> findCarByFuelType(String fuelType){
        return carRepository.findByFuelType(fuelType);
    }

}
