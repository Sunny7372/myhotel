package com.hotelbooking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import java.util.List;
@Configuration
public class SecurityConfig{

    private JWTRequestFilter jwtRequestFilter;

    public SecurityConfig(JWTRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception{
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
              http.authorizeHttpRequests() .anyRequest().permitAll();
                 //requestMatchers("/api/v1/users/addusers","/api/v1/users/Login").permitAll()
                  //    .requestMatchers("/api/v1/users/country").hasRole("ADMIN")
                    //  .anyRequest().authenticated();
         return http.build();
    }
}