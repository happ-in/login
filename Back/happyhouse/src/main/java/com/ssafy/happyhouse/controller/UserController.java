package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    UserService service;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.login(user), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody User user) {
        if (service.join(user)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
