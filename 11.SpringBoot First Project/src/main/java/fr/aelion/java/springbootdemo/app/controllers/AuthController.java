package fr.aelion.java.springbootdemo.app.controllers;

import fr.aelion.java.springbootdemo.app.models.Credentials;
import fr.aelion.java.springbootdemo.app.models.Token;
import fr.aelion.java.springbootdemo.app.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("")
    public Token login(@RequestBody Credentials credentials) { // we can User entity also, we choose a separate model
        // service auth... generate and return fake token if auth is ok
        return new Token(TokenUtils.generateRandomFakeToken());
    }

}
