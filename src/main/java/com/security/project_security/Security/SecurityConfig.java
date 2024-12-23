package com.security.project_security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.security.project_security.Beans.User;


@Configuration
public class SecurityConfig {

//   @Bean
// public UserDetailsService userDetailsService() {

//     // // Define General User
//     // UserDetails generalUser = User
//     //     .withUsername("satyam")
//     //     .password("{noop}1234") // Use {noop} for plain-text passwords
//     //     .roles("NormalUser")
//     //     .build();

//     // // Define Admin User
//     // UserDetails adminUser = User
//     //     .withUsername("admin")
//     //     .password("{noop}admin123") // Use {noop} for plain-text passwords
//     //     .roles("Admin")
//     //     .build();

//     // // Define Public User
//     // UserDetails publicUser = User
//     //     .withUsername("public")
//     //     .password("{noop}public123") // Use {noop} for plain-text passwords
//     //     .roles("PublicUser")
//     //     .build();

//     // Add all users to the in-memory store
//     return new InMemoryUserDetailsManager(generalUser, adminUser, publicUser);
// }
    
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
