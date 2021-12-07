package com.bridgelabz.bookstorebackend.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.exception.JwtExceptionHandler;
import com.bridgelabz.bookstorebackend.exception.UsernameNotFoundException;
import com.bridgelabz.bookstorebackend.implementation.UserDetailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.bridgelabz.bookstorebackend.filter.SecurityConstants.*;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceImpl userDetailService;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/bookstore/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws UsernameNotFoundException {

        LoginDTO applicationUser = null;
        try {
            applicationUser = new ObjectMapper().readValue(req.getInputStream(), LoginDTO.class);
        } catch (Exception e) {
            throw new UsernameNotFoundException("");
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(applicationUser.getEmail(),
                        applicationUser.getPassword(), new ArrayList<>())
        );

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(KEY.getBytes()));

        res.addHeader("auth-token", token);
        res.getWriter().write(token);
        res.getWriter().flush();

    }
}