package com.learning.jwt.application;

import com.learning.jwt.component.JwtHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails[] allowedUsers = new UserDetails[3];
        UserDetails userDetails = User.builder()
                .username("Rahul")
                .password(passwordEncoder().encode("Kumar")).roles("ADMIN").
                build();
        UserDetails userDetails1 = User.builder()
                .username("Prajwal")
                .password(passwordEncoder().encode("Datta")).roles("AGENT").
                build();
        UserDetails userDetails2 = User.builder()
                .username("Rohan")
                .password(passwordEncoder().encode("Kumar")).roles("USER").
                build();
        allowedUsers[0] = userDetails;
        allowedUsers[1] = userDetails2;
        allowedUsers[2] = userDetails1;
        return new InMemoryUserDetailsManager(allowedUsers);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
