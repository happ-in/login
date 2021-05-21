package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.UserServiceImpl;
import com.ssafy.happyhouse.security.jwt.AuthenticationRequest;
import com.ssafy.happyhouse.security.jwt.AuthenticationResponse;
import com.ssafy.happyhouse.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    @Autowired UserServiceImpl service;
    @Autowired private AuthenticationManager manager;
    @Autowired private JwtUtil util;

    @GetMapping
    public ResponseEntity<String> test() {
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.login(user), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuth(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect JWT", e);
        }
        final UserDetails userDetails = service.loadUserByUsername(request.getUsername());
        final String jwt = util.createToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
