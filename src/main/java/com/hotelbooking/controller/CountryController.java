package com.hotelbooking.controller;

import com.hotelbooking.dto.CountryDto;
import com.hotelbooking.entity.Country;
import com.hotelbooking.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country")

public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/country")
    public ResponseEntity<String> addCountry(@RequestBody CountryDto countryDto){
        Country saved = countryService.addUser(countryDto);
        return new ResponseEntity<>("country added", HttpStatus.CREATED);


    }
}
