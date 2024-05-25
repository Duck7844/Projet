package com.example.GoogleLoginLast.Controller;

import com.example.GoogleLoginLast.Security.Security;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/hello")
    public String hello(){
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Login success /n" +
                "Hello "+user.getEmail()+"/n"
                +"<img alt='user' src='"+user.getPicture()+"'></img> ";
    }

    @GetMapping("/no")
    public String no(){
        return  "not yet";
    }
}
