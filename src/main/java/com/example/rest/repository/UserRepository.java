package com.example.rest.repository;

import com.example.rest.authorities.Authorities;
import com.example.rest.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Component
public class UserRepository {
    List<User> userRepository;

    public List<Authorities> getUserAuthorities(String login, String password) {

        for (User user : userRepository) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Arrays.asList(Authorities.values());
            }
        }
        return new ArrayList<>();
    }

    public UserRepository() {
        userRepository = Arrays.asList(
                new User("User1", "123456"),
                new User("User2", "678901")
        );
    }
}
