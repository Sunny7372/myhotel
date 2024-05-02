package com.hotelbooking.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hotelbooking.entity.PropertyUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JWTService {
    private static final String USER_NAME="username";
    @Value("${secretkey}")
    private  String secretkey;
    @Value("${issuer}")
    private  String issuer;
    @Value("${expirytime}")
    private  int expirytime;
    private Algorithm algorithm;

    @PostConstruct
    public void postConstruct(){
        algorithm = Algorithm.HMAC256(secretkey);
        System.out.println(secretkey);
        System.out.println(issuer);
        System.out.println(expirytime);
        System.out.println(algorithm);
    }
    public String createToken(PropertyUser propertyUser){
         return JWT.create().withClaim(USER_NAME,propertyUser.getUsername())
                .withIssuer(issuer)
               .withExpiresAt(new Date(System.currentTimeMillis()+ expirytime))
               .sign(algorithm);
   }

   public String validateToken(String token){
       DecodedJWT verify = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
       return verify.getClaim(USER_NAME).asString();
   }

}
