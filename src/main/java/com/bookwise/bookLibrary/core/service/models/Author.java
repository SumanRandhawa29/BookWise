package com.bookwise.booklibrary.core.service.models;

import com.bookwise.booklibrary.api.models.AuthorV1;
import com.bookwise.booklibrary.core.repositoy.entity.AuthorEntity;


public record Author (int authorId, String name, String email) {

    public AuthorV1 toAuthorV1() {
        return new AuthorV1(authorId(), name(), email());
    }

    public AuthorEntity toAuthorEntity() {
        return new AuthorEntity(authorId, name(), email());
    }


}

