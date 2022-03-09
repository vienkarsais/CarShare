package com.edgars.CarShare.services;

import com.edgars.CarShare.models.CarRegistration;
import com.edgars.CarShare.models.CarRegistrationRequest;

import java.util.List;

public interface CarRegistrationService {
    CarRegistration findById(Long id);
    CarRegistration registerCar(CarRegistrationRequest carRegistrationRequest);
    List<CarRegistration> showAllRegistrations();
    void deleteRegistrationById(Long id);
}
