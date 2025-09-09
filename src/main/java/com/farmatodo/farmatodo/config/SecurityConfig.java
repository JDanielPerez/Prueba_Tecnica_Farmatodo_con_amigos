package com.farmatodo.farmatodo.config;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (modern lambda style)
                .csrf(csrf -> csrf.disable())

                // Allow all requests
                .authorizeHttpRequests(auth -> auth.requestMatchers( "/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**","/user/register").permitAll()  // Endpoints públicos
                        .anyRequest().authenticated())

                // Disable OAuth2 login page redirect
                //.oauth2Login(oauth2 -> oauth2.disable())
                .httpBasic(Customizer.withDefaults())

                // Stateless session (optional for open API)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder pe) {
        return username -> {
            // Usuario hardcodeado: user/pass
            if ("Admin".equals(username)) {
                return User.withUsername("Admin")
                        .password(pe.encode("Admin"))
                        .roles("USER")
                        .build();
            }
            throw new UsernameNotFoundException("No existe: " + username);
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
