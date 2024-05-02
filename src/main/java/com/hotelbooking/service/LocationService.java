package com.hotelbooking.service;

import com.hotelbooking.dto.LocationDto;
import com.hotelbooking.entity.Location;
import com.hotelbooking.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service

public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(LocationDto locationDto){
        Location location= new Location();
        location.setLocationName(locationDto.getLocationName());
         return locationRepository.save(location);


    }
}
