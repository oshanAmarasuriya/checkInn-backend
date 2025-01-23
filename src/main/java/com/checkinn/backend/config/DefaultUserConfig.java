package com.checkinn.backend.config;

import com.checkinn.backend.user.User;
import com.checkinn.backend.user.UserRepository;
import com.checkinn.backend.auth.AuthenticationService;
import com.checkinn.backend.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class DefaultUserConfig {

    @Bean
    CommandLineRunner clr(
            AuthenticationService service,
            UserRepository agentRepository
    ) {
        return args -> {

            Optional<User> defaultAgent = agentRepository.findByUserName("root");
            if (defaultAgent.isEmpty()) {
                RegisterRequest request = new RegisterRequest();
                request.setUserName("root");
                request.setPassword("root");

                service.register(request); // Add default user
            }


        };


    }
}
