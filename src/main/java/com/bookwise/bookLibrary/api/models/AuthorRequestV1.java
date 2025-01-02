package com.bookwise.booklibrary.api.models;

import com.bookwise.booklibrary.api.web.exceptions.EmailPatternMatchException;
import com.bookwise.booklibrary.core.service.models.Author;
import lombok.NonNull;

public record AuthorRequestV1 (@NonNull String name, @NonNull String email)  {

    public AuthorRequestV1 {
        validateEmailAddress(email);
    }


    public Author toAuthor() {
        return new Author(0, this.name, validateEmailAddress(this.email));
    }

    public Author toAuthor(int authorId) {
        return new Author(authorId, this.name, validateEmailAddress(this.email));
    }

    private String validateEmailAddress(String email) {

        // regex match
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new EmailPatternMatchException("Invalid email address");
        }

        if (email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        return email;
    }
}
