package com.example.rest.controller;

import com.example.rest.handler.UserResolver;
import com.example.rest.authorities.Authorities;
import com.example.rest.model.User;
import com.example.rest.service.AuthorizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService  service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserResolver @Valid User user) {
        return service.getAuthorities(user);
    }

    @PostMapping("/reg")
    public User setNewUser(@RequestBody @Valid User user) {
        return service.setUser(user);
    }
}
