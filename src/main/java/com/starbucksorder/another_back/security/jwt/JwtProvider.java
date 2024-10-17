package com.starbucksorder.another_back.security.jwt;

import com.starbucksorder.another_back.entity.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final Key key;

    public JwtProvider(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    private Date getExpirationDate() {
        return new Date(new Date().getTime() + 1000l * 60 * 60 * 3);
    }

    public String generateToken(Admin admin) {
        System.out.println("amdinId :" + admin.getAdminId());
        return Jwts.builder()
                .claim("adminId", admin.getAdminId())
                .signWith(key, SignatureAlgorithm.HS256)
                .expiration(getExpirationDate())
                .compact();
    }

    public String removeBearerToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            throw new RuntimeException();
        }
        return token.substring("Bearer ".length());
    }

    public Claims parseToken(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(key).build();
        return parser.parseClaimsJws(token).getPayload();
    }


}
