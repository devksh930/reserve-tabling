package me.devksh930.tabling.app.auth.domain;

import java.util.Optional;

public interface AuthRepository {

    Optional<AuthAccount> findByEmail(final String email);
}
