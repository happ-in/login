package com.ssafy.happyhouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/qna")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
