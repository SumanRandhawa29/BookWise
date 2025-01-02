package com.bookwise.booklibrary.api.web.exceptions;

public class EmailPatternMatchException extends RuntimeException {
    public EmailPatternMatchException(String msg) {
        super(msg);
    }
}
