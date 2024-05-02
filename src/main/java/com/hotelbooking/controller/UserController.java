package com.hotelbooking.controller;

import com.hotelbooking.dto.Login;
import com.hotelbooking.dto.PropertyUserDto;
import com.hotelbooking.dto.TokenResponse;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addusers")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto propertyUserDto) {
        PropertyUser user = userService.addUser(propertyUserDto);
        if (user != null) {
            return new ResponseEntity<>("Registration Successfull", HttpStatus.CREATED);


        }
        return new ResponseEntity<>("something went wrong", INTERNAL_SERVER_ERROR);

    }
    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody Login login){
        String token = userService.login(login);
        if(token!=null){
            TokenResponse tokenResponse=new TokenResponse();
            tokenResponse.setToken(token);
            return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
        }
        return new ResponseEntity<>("invalid users",HttpStatus.UNAUTHORIZED);


    }


}
