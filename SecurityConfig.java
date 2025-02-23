package com.example.trading.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/static/**", "/", "/index.html").permitAll() // Allow static files
                .anyRequest().authenticated() // Require authentication for other requests
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers("/**")); // Disable CSRF for all routes

        return http.build();
    }
}
