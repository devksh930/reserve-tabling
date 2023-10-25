package me.devksh930.tabling.app.common.util;

import java.time.Duration;
import org.springframework.http.ResponseCookie;

public class CookieUtil {

    private CookieUtil() {
        throw new UnsupportedOperationException();
    }

    public static ResponseCookie create(
        final String name,
        final String value,
        final long maxAgeMillis,
        final String domain
    ) {

        return ResponseCookie.from(name, value)
            .domain(domain)
            .path("/")
            .maxAge(Duration.ofMillis(maxAgeMillis))
            .httpOnly(true)
//            .secure(true)
            .build();
    }

    public static ResponseCookie deleteCookie(
        String name,
        String domain) {
        return ResponseCookie.from(name, "")
            .domain(domain)
            .path("/")
            .maxAge(0)
            .httpOnly(true)
//            .secure(true)
            .build();
    }
}
