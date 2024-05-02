package com.hotelbooking.repository;

import com.hotelbooking.entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<PropertyUser,Long>{
    Optional<PropertyUser> findByUsername(String username);

}
