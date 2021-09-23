package com.example.rest.repository;

import com.example.rest.authorities.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
//        new ArrayList<>(Arrays.asList(Authorities.READ));
        return Collections.emptyList();
    }
}
