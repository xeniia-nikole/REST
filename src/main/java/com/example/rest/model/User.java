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
    private List<Authorities> authorities  = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public User setAuthorities(Authorities authority) {
        authorities.add(authority);
        return this;
    }
}
