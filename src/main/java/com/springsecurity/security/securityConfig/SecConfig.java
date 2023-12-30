package com.springsecurity.security.securityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecConfig {


    @Bean
    SecurityFilterChain doFilter(HttpSecurity http) throws Exception{
        //allow all endPoint
        http.authorizeHttpRequests(
                (auth) -> auth
                        .requestMatchers("/public").permitAll()
        );
        return http.build();
    }
}
