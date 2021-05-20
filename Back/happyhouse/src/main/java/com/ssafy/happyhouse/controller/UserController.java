package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    @Autowired
    UserServiceImpl service;

    @GetMapping
    public ResponseEntity<String> test() {
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.login(user), HttpStatus.OK);
    }
}
