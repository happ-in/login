package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    SqlSession sqlSession;

    @Override
    public User login(User user) {
        return sqlSession.getMapper(UserRepository.class).login(user);
    }

    @Override
    public boolean join(User user) {
        return sqlSession.getMapper(UserRepository.class).join(user) == 1;
    }
}
