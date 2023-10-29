package me.devksh930.tabling.app.account.application;

import static me.devksh930.tabling.app.common.domain.Role.USER;

import java.util.Set;
import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final PasswordEncoder passwordEncoder;

    public AccountMapper(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Account requestToEntity(
        final AccountSignUpRequest request
    ) {

        return new Account(
            request.email(),
            request.name(),
            passwordEncoder.encode(request.password()),
            request.phone(),
            Set.of(USER),
            false,
            false
        );
    }
}
