package com.edgars.CarShare.services;

import com.edgars.CarShare.exceptions.CarRegNotFoundException;
import com.edgars.CarShare.models.Car;
import com.edgars.CarShare.models.CarRegistration;
import com.edgars.CarShare.models.CarRegistrationRequest;
import com.edgars.CarShare.models.User;
import com.edgars.CarShare.repositories.CarRegistrationRepo;
import com.edgars.CarShare.repositories.CarRepository;
import com.edgars.CarShare.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarRegistrationServiceImpl implements CarRegistrationService {
    private UserRepository userRepository;
    private CarRepository carRepository;
    private CarRegistrationRepo carRegistrationRepo;

    @Autowired
    public CarRegistrationServiceImpl(UserRepository userRepository,
                                      CarRepository carRepository,
                                      CarRegistrationRepo carRegistrationRepo) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.carRegistrationRepo = carRegistrationRepo;
    }

    public CarRegistration findById(Long id){
        return carRegistrationRepo.findById(id).orElseThrow(() -> new CarRegNotFoundException("Registration by id: " + id + " not found"));
    }

    public CarRegistration registerCar(CarRegistrationRequest carRegistrationRequest){

        Car car = carRepository.findById(carRegistrationRequest.getCarId()).orElseThrow(() -> new RuntimeException());
        User user = userRepository.findById(carRegistrationRequest.getUserId()).orElseThrow(() -> new RuntimeException());
        CarRegistration carRegistration = new CarRegistration(car, user,
                carRegistrationRequest.getStartingDate(),
                carRegistrationRequest.getEndingDate());
        return carRegistrationRepo.save(carRegistration);
    }
    public List<CarRegistration> showAllRegistrations(){
        return carRegistrationRepo.findAll();
    }
    public void deleteRegistrationById(Long id){
        carRegistrationRepo.deleteById(id);
    }

}
