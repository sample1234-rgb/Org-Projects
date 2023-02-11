package com.cardServices.cardServices.entity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.text.DecimalFormat;
import java.util.*;

@Component
public class Token {
    private String secret;
    private int expirationInMs;
    public void setSecret(String sec){
        this.secret = sec;
    }
    public void setExpirationInMs(int msec){
        this.expirationInMs = msec;
    }
    public String generate(){
        String token = new DecimalFormat("000000").format(new Random().nextInt(999999));
        System.out.println(token);
        return token;
    }
    public String getJWTToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return generateJWTToken(claims, username);
    }
    public String generateJWTToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.expirationInMs)).signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    public Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
