package com.bookwise.booklibrary.core.service.models;

import com.bookwise.booklibrary.api.models.UserResponse;

public record User(int id, String name, String email, String phoneNumber) {

    public UserResponse toUserResponse(){
      return new UserResponse(id(), name(), email(), phoneNumber());
    }

}
