package com.linklite.url_shortener.exception;

public class InvalidURLException extends RuntimeException {

    public InvalidURLException(String message) {
        super(message);
    }

}