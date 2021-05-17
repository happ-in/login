package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.User;

public interface UserService {
    User login(User user);

    // 회원가입
    boolean join(User user);
}
