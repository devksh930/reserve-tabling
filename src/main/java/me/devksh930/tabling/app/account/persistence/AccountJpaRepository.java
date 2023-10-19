package me.devksh930.tabling.app.account.persistence;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, AccountId> {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
