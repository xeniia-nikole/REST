package com.example.rest.model;

import com.example.rest.authorities.Authorities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class User {
    @NotBlank
    @Size(min = 3)
    private String login;
    @Size(min = 4)
    private String password;
    private final List<Authorities> authorities  = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public User setAuthorities(Authorities authority) {
        authorities.add(authority);
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
