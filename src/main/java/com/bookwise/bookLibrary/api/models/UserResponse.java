package com.bookwise.booklibrary.api.models;

import com.bookwise.booklibrary.core.service.models.User;

public record UserResponse(int id, String name, String email, String phoneNumber){}
