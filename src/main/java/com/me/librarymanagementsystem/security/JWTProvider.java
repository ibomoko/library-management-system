package com.me.librarymanagementsystem.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.me.librarymanagementsystem.constant.SecurityConstants;
import com.me.librarymanagementsystem.enums.Role;
import com.me.librarymanagementsystem.model.UserClaims;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Component

public class JWTProvider {
    private final SecurityConstants securityConstants;
    private final JWTVerifier jwtVerifier ;

    public JWTProvider(SecurityConstants securityConstants) {
        this.securityConstants=securityConstants;
        jwtVerifier= JWT
                .require(Algorithm.HMAC512(securityConstants.getJwtSecretKey()))
                .withSubject("jwt-token")
                .withIssuer("library-management-system")
                .build();
    }
        public String generateToken(String email,Role role){
        return  JWT.create()
                .withIssuer("library-management-system")
                .withExpiresAt(getExpireDate())
                .withSubject("jwt-token")
                .withClaim("email",email)
                .withClaim("role",role.toString())
                .withIssuedAt(Instant.now())
                .sign(Algorithm.HMAC512(securityConstants.getJwtSecretKey()));
        }

        public UserClaims validateToken(String token){
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return  UserClaims.builder()
                    .role(Role.valueOf(decodedJWT.getClaim("role").asString()))
                    .email(decodedJWT.getClaim("email").asString())
                    .build();
        }
    private Date getExpireDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR,10);
        return  calendar.getTime();
    }
}
