package me.devksh930.tabling.app.infrastructure.auth;

import java.util.Optional;
import me.devksh930.tabling.app.auth.domain.AuthAccount;
import me.devksh930.tabling.app.auth.domain.AuthRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthJdbcRepository implements AuthRepository {

    private final AuthJdbcDao authJdbcDao;

    public AuthJdbcRepository(
        final AuthJdbcDao authJdbcDao
    ) {
        this.authJdbcDao = authJdbcDao;
    }

    @Override
    public Optional<AuthAccount> findByEmail(final String email) {
        return authJdbcDao.selectByEmail(email);
    }
}
