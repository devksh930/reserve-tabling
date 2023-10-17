package me.devksh930.tabling.app.account.application;

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
        return Account.builder()
            .email(request.email())
            .password(passwordEncoder.encode(request.password()))
            .phone(request.phone())
            .name(request.name())
            .build();
    }
}
