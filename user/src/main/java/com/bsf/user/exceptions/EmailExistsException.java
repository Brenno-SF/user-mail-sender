package com.bsf.user.exceptions;

public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String message) {
        super(message);
    }
}
