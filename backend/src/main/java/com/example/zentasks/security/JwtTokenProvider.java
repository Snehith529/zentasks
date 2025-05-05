package com.example.zentasks.security;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class JwtTokenProvider {
//    private final String SECRET = "secret";
//    public String generateToken(String email) {
//        return Jwts.builder().setSubject(email).signWith(SignatureAlgorithm.HS256, SECRET).compact();
//    }
//}

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(secretKey)
                .compact();
    }
}