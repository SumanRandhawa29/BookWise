package com.bookwise.booklibrary.api.web.v1;

import com.bookwise.booklibrary.api.models.UserResponse;
import com.bookwise.booklibrary.core.service.UsersService;
import com.bookwise.booklibrary.core.service.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return usersService.getUsers().stream()
                .map(User::toUserResponse)
                .toList();
    }
}
