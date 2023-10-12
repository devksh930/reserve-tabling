package me.devksh930.tabling.app.account.application;

import lombok.RequiredArgsConstructor;
import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {


    public Account requestToEntity(
        final AccountSignUpRequest request,
        final PasswordEncoder passwordEncoder
    ) {
        return Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .phone(request.getPhone())
            .name(request.getName())
            .build();
    }
}
