package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    SqlSession sqlSession;

    public User login(User user) {
        return sqlSession.getMapper(UserRepository.class).login(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = sqlSession.getMapper(UserRepository.class).findByUserName(username);
        AccountStatusUserDetailsChecker checker = new AccountStatusUserDetailsChecker();
        return null;
    }
}
