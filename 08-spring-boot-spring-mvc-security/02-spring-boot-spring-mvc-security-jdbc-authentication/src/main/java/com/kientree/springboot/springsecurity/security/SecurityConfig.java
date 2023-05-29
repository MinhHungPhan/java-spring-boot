package com.kientree.springboot.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()

        )
        .formLogin(form ->
                form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        )
        .logout(logout -> logout.permitAll()
        )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
        return http.build();
    }
}
