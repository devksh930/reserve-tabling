package me.devksh930.tabling.app.account.domain;

import lombok.RequiredArgsConstructor;
import me.devksh930.tabling.app.account.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountValidator {

    private final AccountRepository accountRepository;

    public void validate(final Account account) {
        if (accountRepository.existsByEmail(account.getEmail())) {
            throw new RuntimeException("중복된 id");
        }
        if (accountRepository.existsByPhone(account.getPhone())) {
            throw new RuntimeException("중복된 휴대폰 번호");
        }
    }
}
