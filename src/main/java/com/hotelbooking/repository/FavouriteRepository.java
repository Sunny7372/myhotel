package com.hotelbooking.repository;

import com.hotelbooking.entity.Favourite;
import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavouriteRepository extends JpaRepository<Favourite, Long>{
    @Query("Select f from Favourite f where f.property=:property and f.propertyUser=:propertyUser")
    Favourite findFavouriteByPropertyAndPropertyUser(@Param("property")Property property, @Param("propertyUser")PropertyUser propertyUser);
}