package com.example.rest.service;

import com.example.rest.authorities.Authorities;
import com.example.rest.exceptions.InvalidCredentials;
import com.example.rest.exceptions.UnauthorizedUser;
import com.example.rest.model.User;
import com.example.rest.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getLogin()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities =
                userRepository.getUserAuthorities(user.getLogin(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
