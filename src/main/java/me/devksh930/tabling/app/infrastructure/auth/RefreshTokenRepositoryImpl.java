package me.devksh930.tabling.app.infrastructure.auth;

import me.devksh930.tabling.app.auth.domain.RefreshToken;
import me.devksh930.tabling.app.auth.domain.RefreshTokenRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {

    private final RefreshTokenCrudRepository refreshTokenCrudRepository;

    public RefreshTokenRepositoryImpl(
        final RefreshTokenCrudRepository refreshTokenCrudRepository
    ) {
        this.refreshTokenCrudRepository = refreshTokenCrudRepository;
    }

    @Override
    public RefreshToken save(final RefreshToken refreshToken) {
        return refreshTokenCrudRepository.save(refreshToken);

    }

}
