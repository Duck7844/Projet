package com.example.GoogleLoginLast.Controller;

import com.example.GoogleLoginLast.Repository.UserRepository;
import com.example.GoogleLoginLast.Security.Security;
import com.example.GoogleLoginLast.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/hello")
    public String hello(){
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User newUser = new User();
        newUser.setId(user.getSubject());
        newUser.setName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPicture(user.getPicture());
        userRepository.save(newUser);

        return "Login success \nHello " + user.getEmail() + "\n<img alt='user' src='" + user.getPicture() + "'></img>";
    }

    @GetMapping("/no")
    public String no(){
        return  "not yet";
    }
}
