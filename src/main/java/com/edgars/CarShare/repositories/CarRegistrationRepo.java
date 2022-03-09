package com.edgars.CarShare.repositories;

import com.edgars.CarShare.models.CarRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRegistrationRepo extends JpaRepository<CarRegistration, Long> {
}
