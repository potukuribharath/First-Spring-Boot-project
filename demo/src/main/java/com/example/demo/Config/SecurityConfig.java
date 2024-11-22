package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.GET, "/stud").authenticated()
                        .requestMatchers(HttpMethod.GET, "/detail/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/stud/add").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults())

                .logout(withDefaults());
        return http.build();
    }
    @Bean public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user") .password(passwordEncoder().encode("pass")) .roles("USER") .build();
        UserDetails admin = User.withUsername("admin") .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); }

}
