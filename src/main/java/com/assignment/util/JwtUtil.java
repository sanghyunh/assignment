package com.assignment.util;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.assignment.constant.Errors;
import com.assignment.dto.TokenDto.TokenPayloadDto;
import com.assignment.exception.CommonException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final ConverterUtil converterUtil;
    private final InitProperties initProperties;

    public String encData(Object claim, Date expiration) {
        SecretKey secretKey = Keys.hmacShaKeyFor(this.initProperties.getJwtKey().getBytes());
        JwtBuilder builder = Jwts.builder();

        builder.setHeaderParam("typ", "JWT");
        builder.setSubject("token");
        builder.setExpiration(expiration);
        builder.setIssuedAt(new Date());
        if (!ObjectUtils.isEmpty(claim)) {
            builder.claim("claim", claim);
        }
        builder.signWith(secretKey);
        return builder.compact();
    }

    public TokenPayloadDto decData(String secureData) {
        SecretKey encodeSecretKey = Keys.hmacShaKeyFor(this.initProperties.getJwtKey().getBytes());
        Claims body;
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(encodeSecretKey)
                    .build()
                    .parseClaimsJws(secureData);
            body = claims.getBody();
        } catch (JwtException e) {
            log.error("Validate jwtData error::{}", e.getMessage(), e);
            throw new CommonException(Errors.JWT_DECRYPT_ERROR);
        }
        return this.converterUtil.toObject(this.converterUtil.toJsonString(body), TokenPayloadDto.class);
    }
}
