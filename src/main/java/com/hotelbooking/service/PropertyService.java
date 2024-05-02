package com.hotelbooking.service;

import com.hotelbooking.dto.PropertyDto;
import com.hotelbooking.entity.Location;
import com.hotelbooking.entity.Property;
import com.hotelbooking.repository.LocationRepository;
import com.hotelbooking.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private LocationRepository locationRepository;

    public PropertyService(PropertyRepository propertyRepository, LocationRepository locationRepository) {
        this.propertyRepository = propertyRepository;
        this.locationRepository = locationRepository;
    }
    public void addProperty(PropertyDto propertyDto){
        Property property=new Property();
        property.setPropertyName(propertyDto.getPropertyName());
        property.setCountry(propertyDto.getCountry());
        property.setGuests(propertyDto.getGuests());
        property.setBedRooms(propertyDto.getBedRooms());
        property.setLocation(propertyDto.getLocation());
        property.setNightlyPrice(propertyDto.getNightlyPrice());
        propertyRepository.save(property);
    }

    public List<Property> fetchProperty(PropertyDto propertyDto) {
        Location location = propertyDto.getLocation();
        List<Property> propertyByLocation = propertyRepository.findPropertyByLocation(location);
        return propertyByLocation;

        //Location location = locationRepository.findById(locationId).get();


        //List<Property> propertyByLocation = propertyRepository.findPropertyByLocation(location);
        //return propertyByLocation;
    }
}
