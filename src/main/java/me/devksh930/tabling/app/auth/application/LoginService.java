package me.devksh930.tabling.app.auth.application;

import me.devksh930.tabling.app.auth.domain.TokenManager;
import me.devksh930.tabling.app.auth.dto.request.LoginRequest;
import me.devksh930.tabling.app.auth.dto.respone.TokenResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final TokenManager tokenManager;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    public LoginService(
        final TokenManager tokenManager,
        final AuthenticationManagerBuilder authenticationManagerBuilder
    ) {
        this.tokenManager = tokenManager;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public TokenResponse login(final LoginRequest loginRequest) {
        final AuthenticationManager authenticationManager = authenticationManagerBuilder.getObject();
        final Authentication authenticate = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        return tokenManager.createToken(authenticate);
    }

}
