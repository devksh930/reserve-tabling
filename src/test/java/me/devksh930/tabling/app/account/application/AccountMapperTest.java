package me.devksh930.tabling.app.account.application;

import static me.devksh930.tabling.app.fixture.MonkeyUtil.monkey;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class AccountMapperTest {

    private AccountMapper accountMapper;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void init() {
        this.accountMapper = new AccountMapper();
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void requestToEntity() {

        final AccountSignUpRequest request = monkey().giveMeOne(AccountSignUpRequest.class);

        final Account account = accountMapper.requestToEntity(request, passwordEncoder);

        assertThat(account.getId()).isNotNull();
    }
}