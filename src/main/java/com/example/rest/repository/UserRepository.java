package com.example.rest.repository;

import com.example.rest.authorities.Authorities;
import com.example.rest.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Component
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger userId = new AtomicInteger(1);

    public List<Authorities> getUserAuthorities(String userName, String password) {
        for(User user : users.values()) {
            if(user.getLogin().equals(userName) && user.getPassword().equals(password)) {
                return user.getAuthorities();
            }
        }
        return null;
    }

    public User setNewUser(User user) {
        user.setAuthorities(Authorities.READ).setAuthorities(Authorities.WRITE);
        int id = userId.getAndIncrement();
        users.put(String.valueOf(id), user);
        return user;
    }
}
