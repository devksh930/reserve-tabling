package me.devksh930.tabling.app.auth.domain;

import me.devksh930.tabling.app.auth.dto.respone.TokenResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenManager(
        final RefreshTokenRepository refreshTokenRepository,
        final JwtTokenProvider jwtTokenProvider
    ) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public TokenResponse createToken(final Authentication authenticate) {
        final Token accessToken = jwtTokenProvider.createAccessToken(authenticate);
        final Token refreshToken = jwtTokenProvider.createRefreshToken();
        refreshTokenRepository.save(
            new RefreshToken(
                authenticate.getName(),
                refreshToken.token(),
                refreshToken.validityInMilliseconds()
            )
        );
        return new TokenResponse(
            accessToken.token(),
            refreshToken.token(),
            accessToken.validityInMilliseconds(),
            refreshToken.validityInMilliseconds()
        );
    }

}
