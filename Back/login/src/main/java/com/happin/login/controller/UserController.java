package com.happin.login.controller;

import com.happin.login.jwt.JwtTokenProvider;
import com.happin.login.model.domain.User;
import com.happin.login.model.repository.UserRepository;
import com.happin.login.model.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserDetailService userDetailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable("id") Long id) {
        return userDetailService.findById(id);
    }

    // 회원가입
    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .userid(user.get("userid"))
                .userpwd(passwordEncoder.encode(user.get("userpwd")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByUserid(user.get("userid"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(user.get("userpwd"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
