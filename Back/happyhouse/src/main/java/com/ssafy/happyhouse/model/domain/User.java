package com.ssafy.happyhouse.model.domain;

import lombok.Data;

@Data
public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String email;
    private String address;
    private String joindate;
}
