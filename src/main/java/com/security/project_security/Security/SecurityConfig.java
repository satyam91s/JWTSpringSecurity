package com.security.project_security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
    @Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
        .csrf(csrf -> csrf.disable()) // Disable CSRF
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/home/public").permitAll() // Public endpoint
            .anyRequest().authenticated() // All other requests need authentication
        )
        .formLogin(form -> form
            // .loginPage("/login") // Customize login page if needed
            .permitAll()
        );

    return httpSecurity.build();
}
    
}
