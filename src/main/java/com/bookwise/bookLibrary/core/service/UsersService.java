package com.bookwise.booklibrary.core.service;

import com.bookwise.booklibrary.core.service.models.User;
import com.bookwise.booklibrary.external.User.UserApi;
import com.bookwise.booklibrary.external.User.model.ExternalUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UserApi userApi;

    public UsersService(UserApi userApi) {
        this.userApi = userApi;
    }

    public List<User> getUsers() {
        return userApi.getUsers().stream()
                .map(ExternalUser::toUser)
                .toList();
    }
}
