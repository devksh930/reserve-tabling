package me.devksh930.tabling.app.infrastructure.auth;

import me.devksh930.tabling.app.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenCrudRepository extends CrudRepository<RefreshToken, String> {

}
