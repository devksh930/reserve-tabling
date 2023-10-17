package me.devksh930.tabling.app.account.application;

import static me.devksh930.tabling.app.fixture.MonkeyUtil.monkey;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class AccountMapperTest {

    private AccountMapper accountMapper;

    @BeforeEach
    void init() {
        this.accountMapper = new AccountMapper(new BCryptPasswordEncoder());
    }

    @Test
    @DisplayName("AccountSignUpRequest를 Account엔티티로 변환한다")
    void requestToEntity() {

        final AccountSignUpRequest request = monkey().giveMeOne(AccountSignUpRequest.class);

        final Account account = accountMapper.requestToEntity(request);

        assertThat(account.getAccountId().getValue()).isNotEmpty();
        assertThat(account.getEmail()).isNotEmpty();
        assertThat(account.getName()).isNotEmpty();
        assertThat(account.getPassword()).isNotEmpty();
        assertThat(account.getPhone()).isNotEmpty();
    }
}
