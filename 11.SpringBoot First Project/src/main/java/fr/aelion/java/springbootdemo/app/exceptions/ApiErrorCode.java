package fr.aelion.java.springbootdemo.app.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ApiErrorCode {

    CONTENT_NOT_FOUND("404_XYZ", "Content Not Found");

    private final String msg;
    private final String code;
    // HttpStatusCode...

    private ApiErrorCode(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }
}
