package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager uesrDetailManager(){
//        UserDetails john = User.builder().username("john").password("{noop}test").roles("EMPLOYEE").build();
//        UserDetails lisa = User.builder().username("lisa").password("{noop}test").roles("EMPLOYEE","MANAGER").build();
//        UserDetails mary = User.builder().username("mary").password("{noop}test").roles("EMPLOYEE","MANAGER","ADMIN").build();
//        return new InMemoryUserDetailsManager(john,lisa,mary);
//    }

    // add support for jdbc
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
         http.authorizeHttpRequests(configurer -> configurer
                 .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                 .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                 .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                 .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                 .requestMatchers(HttpMethod.DELETE,"/api/employees").hasRole("ADMIN")
         );
         //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
