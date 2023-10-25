package me.devksh930.tabling.app.auth.domain;

import static me.devksh930.tabling.app.auth.domain.JwtTokenProvider.AUTHORITIES_KEY;
import static me.devksh930.tabling.app.auth.domain.JwtTokenProvider.AUTHORITY_DELIMITER;
import static me.devksh930.tabling.app.auth.domain.JwtTokenProvider.TOKEN_TYPE_KEY;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
public class JwtTokenParser {
    private final JwtParser jwtParser;

    public JwtTokenParser(final String secretKey) {
        final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public Authentication extractAuthentication(final String accessToken) {
        try {
            final Claims claims = jwtParser.parseClaimsJws(accessToken).getBody();
            final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(AUTHORITY_DELIMITER))
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            final UserDetails principal = User.builder()
                .username(claims.getSubject())
                .password("N/A")
                .authorities(authorities)
                .build();

            return new UsernamePasswordAuthenticationToken(principal, accessToken, authorities);
        } catch (final JwtException | IllegalArgumentException | NullPointerException exception) {
            throw new BadCredentialsException(exception.getMessage());
        }
    }

    public boolean validateAccessToken(final String token) {
        return validateToken(token, TokenType.ACCESS);
    }

    public boolean validateRefreshToken(final String token) {
        return validateToken(token, TokenType.REFRESH);
    }

    private boolean validateToken(final String token, final TokenType tokenType) {
        try {
            final Claims claims = jwtParser.parseClaimsJws(token).getBody();
            final TokenType extractedType = TokenType.valueOf((String) claims.get(TOKEN_TYPE_KEY));

            return !claims.getExpiration().before(new Date()) && extractedType == tokenType;
        } catch (final JwtException | IllegalArgumentException exception) {
            return false;
        }
    }
}
