package com.hotelbooking.configuration;

import com.hotelbooking.entity.PropertyUser;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.JWTService;
import com.hotelbooking.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    private UserService userService;
    private JWTService jwtService;
    private UserRepository userRepository;

    public JWTRequestFilter(UserService userService, JWTService jwtService, UserRepository userRepository) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(8, tokenHeader.length() - 1);
            String username = jwtService.validateToken(token);
            Optional<PropertyUser> byUsername = userRepository.findByUsername(username);
            if(byUsername.isPresent()){
                PropertyUser propertyUser = byUsername.get();
                UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(propertyUser,null, Collections.singleton(new SimpleGrantedAuthority(propertyUser.getUserRole())));
                authentication.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }



        }

        filterChain.doFilter(request,response);

    }

}
