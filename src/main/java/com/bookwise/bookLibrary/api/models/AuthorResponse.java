package com.bookwise.booklibrary.api.models;

import java.util.List;

public record AuthorResponse(List<AuthorV1> authors, long count) {}
