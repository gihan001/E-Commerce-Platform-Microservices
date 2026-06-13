package com.ecommerce.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 1. Password එක Encrypt කරන මෙවලම හඳුන්වා දීම
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Endpoint වල ආරක්ෂක රීති සැකසීම
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // REST API සඳහා CSRF අවශ්‍ය නොවේ
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Register සහ Login කාටත් විවෘතයි
                        .anyRequest().authenticated() // අනෙක් සියලුම ඉල්ලීම් වලට ආරක්ෂාව අවශ්‍යයි
                );
        return http.build();
    }
}