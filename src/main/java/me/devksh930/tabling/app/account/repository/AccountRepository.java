package me.devksh930.tabling.app.account.repository;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, AccountId> {

    boolean existsByEmail(final String email);

    boolean existsByPhone(final String phone);
}
