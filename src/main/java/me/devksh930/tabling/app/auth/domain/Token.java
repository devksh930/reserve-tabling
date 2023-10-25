package me.devksh930.tabling.app.auth.domain;

import java.util.Date;

public record Token(
    String token,
    Date validity,
    long validityInMilliseconds
) {

}
