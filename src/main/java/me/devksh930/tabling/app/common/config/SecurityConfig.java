package me.devksh930.tabling.app.common.config;

import jakarta.servlet.DispatcherType;
import me.devksh930.tabling.app.common.config.filter.JwtFilter;
import me.devksh930.tabling.app.common.domain.JwtTokenParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final String secretKey;

    public SecurityConfig(@Value("${custom.jwt.secretKey}") final String secretKey) {
        this.secretKey = secretKey;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(request ->
                request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers(HttpMethod.POST, "/accounts").permitAll()
                    .requestMatchers(HttpMethod.GET, "/accounts").authenticated()
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .anyRequest()
                    .authenticated()
            )
            .sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public JwtTokenParser jwtTokenParser() {
        return new JwtTokenParser(secretKey);
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter(jwtTokenParser());
    }

}
