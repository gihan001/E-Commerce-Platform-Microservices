package com.ecommerce.user.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    // Token එක ආරක්ෂිතව Sign කිරීමට අවශ්‍ය කරන රහස් කේතය (Secret Key)
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token එකක් වලංගු වන කාලය (මිලි තත්පර වලින් - පැය 24ක් සඳහා)
    private static final long EXPIRATION_TIME = 86400000;

    // ඩිජිටල් ටෝකන් එක නිර්මාණය කරන මෙතඩ් එක
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role) // පරිශීලකයාගේ භූමිකාව (Role) ඇතුළත් කිරීම
                .setIssuedAt(new Date()) // සාදපු වෙලාව
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // ඉකුත් වන වෙලාව
                .signWith(key) // රහස් කේතයෙන් අත්සන් තැබීම
                .compact();
    }
}