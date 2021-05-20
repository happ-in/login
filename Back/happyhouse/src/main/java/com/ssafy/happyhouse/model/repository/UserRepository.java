package com.ssafy.happyhouse.model.repository;

import com.ssafy.happyhouse.model.domain.User;

public interface UserRepository {
    User login(User user);
}
