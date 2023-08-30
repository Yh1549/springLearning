package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager uesrDetailManager(){
        UserDetails john = User.builder().username("john").password("{noop}test").roles("EMPLOYEE").build();
        UserDetails lisa = User.builder().username("lisa").password("{noop}test").roles("EMPLOYEE","MANAGER").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test").roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(john,lisa,mary);
    }

    @Re
}
