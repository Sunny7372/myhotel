package com.hotelbooking.controller;

import com.hotelbooking.dto.FavouriteDto;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.service.FavouriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/favourite")
public class FavouriteController{
    private FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/addFavourite")
    public ResponseEntity<String> addFavourite(@RequestBody FavouriteDto favouriteDto, @AuthenticationPrincipal PropertyUser propertyUser){
        String s = favouriteService.addFavourite(favouriteDto, propertyUser);
        return new ResponseEntity<>(s, HttpStatus.CREATED);


    }

}
