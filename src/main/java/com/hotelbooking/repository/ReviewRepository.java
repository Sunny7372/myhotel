package com.hotelbooking.repository;

import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.property=:property AND r.propertyUser=:user")
    Review findReviewByPropertyAndPropertyUser(@Param("property") Property property,@Param("user") PropertyUser user);
}
