package me.devksh930.tabling.app.auth.domain;

import static me.devksh930.tabling.app.common.config.SecurityConstant.AUTHORITIES_KEY;
import static me.devksh930.tabling.app.common.config.SecurityConstant.AUTHORITY_DELIMITER;
import static me.devksh930.tabling.app.common.config.SecurityConstant.TOKEN_TYPE_KEY;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import me.devksh930.tabling.app.common.domain.TokenType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final long accessTokenValidityInMilliseconds;
    private final long refreshTokenValidityInMilliseconds;
    private final Key secretKey;

    public JwtTokenProvider(
        @Value("${custom.jwt.secretKey}") String secretKey,
        @Value("${custom.jwt.access-token-validity-in-milliseconds}") long accessTokenValidityInMilliseconds,
        @Value("${custom.jwt.refresh-token-validity-in-milliseconds}") long refreshTokenValidityInMilliseconds
    ) {
        this.accessTokenValidityInMilliseconds = accessTokenValidityInMilliseconds;
        this.refreshTokenValidityInMilliseconds = refreshTokenValidityInMilliseconds;
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public Token createAccessToken(final Authentication authentication) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + (accessTokenValidityInMilliseconds));

        final String accessToken = Jwts.builder()
            .setSubject(authentication.getName())
            .claim(AUTHORITIES_KEY, toString(authentication.getAuthorities()))
            .claim(TOKEN_TYPE_KEY, TokenType.ACCESS)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .setIssuedAt(now)
            .setExpiration(validity)
            .compact();
        return new Token(accessToken, validity, accessTokenValidityInMilliseconds);

    }

    public Token createRefreshToken() {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + refreshTokenValidityInMilliseconds);

        final String refreshToken = Jwts.builder()
            .claim(TOKEN_TYPE_KEY, TokenType.REFRESH)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .setIssuedAt(now)
            .setExpiration(validity)
            .compact();

        return new Token(refreshToken, validity, refreshTokenValidityInMilliseconds);
    }

    private String toString(
        final Collection<? extends GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(AUTHORITY_DELIMITER));
    }
}
