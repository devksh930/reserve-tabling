package me.devksh930.tabling.app.account.application;

import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountValidator;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import me.devksh930.tabling.app.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountSignUpService {

    private final AccountRepository accountRepository;
    private final AccountValidator accountValidator;
    private final AccountMapper accountMapper;

    public AccountSignUpService(
        final AccountRepository accountRepository,
        final AccountValidator accountValidator,
        final AccountMapper accountMapper
    ) {
        this.accountRepository = accountRepository;
        this.accountValidator = accountValidator;
        this.accountMapper = accountMapper;
    }

    public String signUp(
        final AccountSignUpRequest request
    ) {
        final Account account = accountMapper.requestToEntity(request);
        accountValidator.validate(account);
        final Account save = accountRepository.save(account);

        return save.getEmail();
    }
}
