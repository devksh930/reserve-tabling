package me.devksh930.tabling.app.auth.ui;

import me.devksh930.tabling.app.auth.application.LoginService;
import me.devksh930.tabling.app.auth.dto.request.LoginRequest;
import me.devksh930.tabling.app.auth.dto.respone.TokenResponse;
import me.devksh930.tabling.app.common.util.CookieUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;
    private final String domain;

    public AuthController(
        final LoginService loginService,
        @Value("${custom.cookieDomain}") final String domain
    ) {
        this.loginService = loginService;
        this.domain = domain;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
        @RequestBody final LoginRequest loginRequest
    ) {
        final TokenResponse login = loginService.login(loginRequest);

        final HttpHeaders loginHeader = createLoginHeader(login);

        return ResponseEntity.ok()
            .headers(loginHeader)
            .build();
    }

    private HttpHeaders createLoginHeader(final TokenResponse token) {
        ResponseCookie refreshTokenCookie = CookieUtil.create(
            "refresh",
            token.refreshToken(),
            token.accessTokenValidityInMilliseconds(),
            domain
        );
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());
        httpHeaders.add(HttpHeaders.AUTHORIZATION, token.accessToken());
        return httpHeaders;
    }
}
