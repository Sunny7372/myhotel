package com.hotelbooking.service;

import com.hotelbooking.dto.CountryDto;
import com.hotelbooking.entity.Country;
import com.hotelbooking.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addUser(CountryDto countryDto){
        Country country= new Country();
        country.setCountryName(countryDto.getCountryName());
        Country save = countryRepository.save(country);
        return save;


    }
}
