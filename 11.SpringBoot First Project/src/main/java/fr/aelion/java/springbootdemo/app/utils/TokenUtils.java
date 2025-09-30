package fr.aelion.java.springbootdemo.app.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

public class TokenUtils {

    // Injection d'un object @Config...
    // @Value("${app.token.secret}")
    // TODO: set final and @Value in constructor
    private static final String secret = "SECRET";

    public static String generateRandomFakeToken() {
        // JWT inspiration; should be JWT.generate()..
        return "header.payload.signature";
    }

    public static boolean checkRandomFakeToken(String token) {
        String[] parts = token.split("\\.");
        String signature = parts[2];
        // JWT inspiration
        // if(hash(parts[0], parts[1], secret) = signature)
        return true;
    }
}
