package com.example.GoogleLoginLast.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@EnableWebSecurity
@Configuration
public class Security {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authorizeRequests) -> authorizeRequests.anyRequest().authenticated()
        ).oauth2Login(oauth2Customize -> oauth2Customize
                .loginPage("/oauth2/authorization/google")
                .defaultSuccessUrl("/hello", true) // Chuyển hướng đến trang chủ sau khi đăng nhập thành công
                .failureUrl("/no")); // Chuyển hướng đến trang đăng nhập với thông báo lỗi
        return http.build();
    }
}