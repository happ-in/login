package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    SqlSession sqlSession;

    public User login(User user) {
        return sqlSession.getMapper(UserRepository.class).login(user);
    }
}
