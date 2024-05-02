package com.hotelbooking.service;

import com.hotelbooking.dto.FavouriteDto;
import com.hotelbooking.entity.Favourite;
import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.repository.FavouriteRepository;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService {
    private FavouriteRepository favouriteRepository;

    public FavouriteService(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    public String addFavourite(FavouriteDto favouriteDto, PropertyUser propertyUser) {
        Property property = favouriteDto.getProperty();
        Favourite f=favouriteRepository.findFavouriteByPropertyAndPropertyUser(property,propertyUser);
        if(f!=null){
            return "favourite already given";
        }
        Favourite favourite= new Favourite();
        favourite.setPropertyUser(propertyUser);
        favourite.setProperty(property);
        favourite.setIsFavourite(favouriteDto.getIsFavourite());
        favouriteRepository.save(favourite);
        return "favourite added successfully";
    }
}
