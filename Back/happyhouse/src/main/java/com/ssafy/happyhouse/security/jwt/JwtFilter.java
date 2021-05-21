package com.ssafy.happyhouse.security.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");  // request 에서 Authorization Header 추출

        String token = null;
        String username = null;

        // header가 happyhouse로 시작하면 username 추출
        if (authHeader != null && authHeader.startsWith("happyhouse")) {
            token = authHeader.substring(10);
            username = "123";
        }

        // username이 null이 아니면 token의 값이 정상적
        // SecurityContextHolder의 auth가 비어있다면 최초 인증
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
