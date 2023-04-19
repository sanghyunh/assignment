package com.assignment.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class InitProperties {

    @Value("${jwt.key}")
    private String jwtKey;

}
