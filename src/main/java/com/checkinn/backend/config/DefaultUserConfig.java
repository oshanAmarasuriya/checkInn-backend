package com.checkinn.backend.config;

import com.checkinn.backend.agent.Agent;
import com.checkinn.backend.agent.AgentRepository;
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
            AgentRepository agentRepository
    ) {
        return args -> {

            Optional<Agent> defaultAgent = agentRepository.findByUserName("root");
            if (defaultAgent.isEmpty()) {
                RegisterRequest request = new RegisterRequest();
                request.setUserName("root");
                request.setPassword("root");

                service.register(request); // Add default user
            }


        };


    }
}
