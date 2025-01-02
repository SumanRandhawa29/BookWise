package com.bookwise.booklibrary.api.web.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String msg) {
        super(msg);
    }
}
