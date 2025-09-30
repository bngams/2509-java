package fr.aelion.java.springbootdemo.app.exceptions;

public class ContentNotFoundException extends GlobalException {
    // Autre constructeur possible :  Type d'object : type, ID: recherché
    public ContentNotFoundException(String msg) {
        super(ApiErrorCode.CONTENT_NOT_FOUND, msg);
    }
}
