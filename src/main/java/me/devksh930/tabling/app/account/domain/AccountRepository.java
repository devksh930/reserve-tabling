package me.devksh930.tabling.app.account.domain;

public interface AccountRepository {

    boolean existsByEmail(final String email);

    boolean existsByPhone(final String phone);

    Account save(Account account);
}
