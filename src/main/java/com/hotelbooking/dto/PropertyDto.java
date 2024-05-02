package com.hotelbooking.dto;

import com.hotelbooking.entity.Country;
import com.hotelbooking.entity.Location;
import jakarta.persistence.*;

public class PropertyDto {


    private String propertyName;



    private Country country;


    private Location location;


    private String bedRooms;


    private Integer nightlyPrice;


    private Integer guests;

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(Integer nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public String getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(String bedRooms) {
        this.bedRooms = bedRooms;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }




}
