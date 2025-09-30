package fr.aelion.java.springbootdemo.app.models;

import lombok.Data;

// MODEL != ENTITY
// ENTITY => JPA =>  "direct link" with DB
// Credentials can be treated as a User DTO Model
@Data
public class Credentials {
    private String email;
    private String pwd;
}
