package com.happin.login.controller;

import com.happin.login.model.domain.User;
import com.happin.login.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
