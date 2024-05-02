package com.hotelbooking.repository;

import com.hotelbooking.entity.Location;
import com.hotelbooking.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("select p from Property p where p.location=:location")
    List<Property> findPropertyByLocation(@Param("location") Location location);

}