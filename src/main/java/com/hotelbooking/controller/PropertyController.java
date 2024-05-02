package com.hotelbooking.controller;

import com.hotelbooking.dto.PropertyDto;
import com.hotelbooking.entity.Property;
import com.hotelbooking.repository.PropertyRepository;
import com.hotelbooking.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    private PropertyRepository propertyRepository;
    private PropertyService propertyService ;

    public PropertyController(PropertyRepository propertyRepository, PropertyService propertyService) {
        this.propertyRepository = propertyRepository;
        this.propertyService = propertyService;
    }
    @PostMapping("/addproperty")
    public ResponseEntity<String> addProperty(@RequestBody PropertyDto propertyDto){

        propertyService.addProperty(propertyDto);
        return new ResponseEntity<>("propertyadded", HttpStatus.CREATED);
    }
    /*@GetMapping("/getpropertybylocation/{locationId}")
    public ResponseEntity<List<Property>>fetchProperty(@PathVariable long locationId){
        List<Property> property = propertyService.fetchProperty(locationId);
        return new ResponseEntity<>(property,HttpStatus.OK);
    }*/

    @GetMapping("/getpropertybylocation")
    public ResponseEntity<List<Property>>fetchProperty(@RequestBody PropertyDto propertyDto) {
        List<Property> property = propertyService.fetchProperty(propertyDto);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }
}