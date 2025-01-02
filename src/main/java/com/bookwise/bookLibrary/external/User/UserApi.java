package com.bookwise.booklibrary.external.User;

import com.bookwise.booklibrary.external.User.model.ExternalUser;

import java.util.List;

public interface UserApi {
    public List<ExternalUser> getUsers();
}
