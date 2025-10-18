package com.example.ZETA_Api_MongoDB.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomAcessDeniedHandler customAcessDeniedHandler;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode(adminPassword))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // API REST não precisa de CSRF

                .authorizeHttpRequests(auth -> auth
                        // Swagger protegido apenas para ADMIN
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**"
                        ).hasRole("ADMIN")

                        // API pública
                        .requestMatchers("/api/**").permitAll()

                        // Qualquer outra rota precisa autenticação
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults()) // Basic Auth para Swagger
                .formLogin(Customizer.withDefaults())  // Form login opcional para Swagger
                .logout(Customizer.withDefaults())

                .exceptionHandling(ex -> ex.accessDeniedHandler(customAcessDeniedHandler));

        return http.build();
    }
}
