package me.devksh930.tabling.app.account.application;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountManager;
import me.devksh930.tabling.app.account.domain.AccountValidator;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountSignUpService {

    private final AccountManager accountManager;
    private final AccountValidator accountValidator;
    private final AccountMapper accountMapper;

    public AccountSignUpService(
        final AccountManager accountManager,
        final AccountValidator accountValidator,
        final AccountMapper accountMapper
    ) {
        this.accountManager = accountManager;
        this.accountValidator = accountValidator;
        this.accountMapper = accountMapper;
    }

    public Long signUp(
        final AccountSignUpRequest request
    ) {
        final Account account = accountMapper.requestToEntity(request);
        accountValidator.validate(account);
        return accountManager.create(account);
    }

}
