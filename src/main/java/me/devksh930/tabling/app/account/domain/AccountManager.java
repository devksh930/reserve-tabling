package me.devksh930.tabling.app.account.domain;

import org.springframework.stereotype.Component;

@Component
public class AccountManager {

    private final AccountRepository accountRepository;

    public AccountManager(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long create(final Account account) {
        final Account save = accountRepository.save(account);
        return save.getId();
    }
}
