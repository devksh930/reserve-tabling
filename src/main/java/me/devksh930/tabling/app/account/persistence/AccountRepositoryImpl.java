package me.devksh930.tabling.app.account.persistence;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;

    public AccountRepositoryImpl(final AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public boolean existsByEmail(final String email) {
        return accountJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(final String phone) {
        return accountJpaRepository.existsByPhone(phone);
    }

    @Override
    public Account save(final Account account) {
        return accountJpaRepository.save(account);
    }
}
