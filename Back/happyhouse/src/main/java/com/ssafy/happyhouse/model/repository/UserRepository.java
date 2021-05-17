package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.dto.User;

public interface UserRepository {
    // 로그인
    User login(User user);

    // 회원가입
    int join(User user);
}
