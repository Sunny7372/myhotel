package com.hotelbooking.service;

import com.hotelbooking.dto.Login;
import com.hotelbooking.dto.PropertyUserDto;
import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private JWTService jwtService;

    public UserService(UserRepository userRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public PropertyUser addUser(PropertyUserDto propertyUserDto){
        PropertyUser user=new PropertyUser();
        user.setUsername(propertyUserDto.getUsername());
        user.setEmail(propertyUserDto.getEmail());
        user.setUserRole(propertyUserDto.getUserRole());
        user.setFirstName(propertyUserDto.getFirstName());
        user.setLastName(propertyUserDto.getLastName());
        user.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(),BCrypt.gensalt(10)));
        PropertyUser savedUser = userRepository.save(user);
        return savedUser;


    }

    public String login(Login login) {
        Optional<PropertyUser> byUsername = userRepository.findByUsername(login.getUsername());
       if( byUsername.isPresent()){
           PropertyUser propertyUser = byUsername.get();
          if( BCrypt.checkpw(login.getPassword(),propertyUser.getPassword())){
              return jwtService.createToken(propertyUser);
          }
       }
       return null;


    }
}
