package com.edgars.CarShare.repositories;

import com.edgars.CarShare.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
