package com.kientree.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // Add support for JDBC ...no more hardcoded users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Set the queries to retrieve a user by username
        String usersByUsernameQuery = "SELECT user_id, pw, active FROM members WHERE user_id = ?";

        // Set the queries to retrieve authorities/roles by username
        String authoritiesByUsernameQuery = "SELECT user_id, role FROM roles WHERE user_id = ?";

        jdbcUserDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(authoritiesByUsernameQuery);

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws  Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // Use HTTP Basic Authentication
        http.httpBasic();

        // Disable Cross Site Request Forgery (CSRF)
        // In general, CSRF protection is not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf().disable();

        return http.build();
    }
}
