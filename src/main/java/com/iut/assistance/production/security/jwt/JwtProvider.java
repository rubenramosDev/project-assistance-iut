package com.iut.assistance.production.security.jwt;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.security.models.AuthenticationUser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Integer expirationTime;

    public String generateToken(Authentication authentication){
        AuthenticationUser user = (AuthenticationUser) authentication.getPrincipal();



        List<String> privileges = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("privileges", privileges)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expirationTime * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes())
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean tokenValidation(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            throw new ApiRequestException("Le token n'est pas bon");
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            throw new ApiRequestException("Le token n'est pas bon");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new ApiRequestException("Token vide");
        } catch (SignatureException e) {
            e.printStackTrace();
            throw new ApiRequestException("Le token n'est pas bon");
        }
    }
}
