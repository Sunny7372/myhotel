package com.hotelbooking.controller;

import com.hotelbooking.dto.LocationDto;
import com.hotelbooking.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping("/location")

    public ResponseEntity<String> addLocation(@RequestBody LocationDto locationDto){
        locationService.addLocation(locationDto);
        return new ResponseEntity<>("LocationAdded", HttpStatus.CREATED);
    }
}
