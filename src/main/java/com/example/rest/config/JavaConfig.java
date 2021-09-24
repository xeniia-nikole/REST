package com.example.rest.config;

import com.example.rest.controller.AuthorizationController;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public AuthorizationController authorizationController() {
        return new AuthorizationController(authorizationService());
    }

}
