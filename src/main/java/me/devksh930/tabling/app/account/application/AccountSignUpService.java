package me.devksh930.tabling.app.account.application;

import lombok.RequiredArgsConstructor;
import me.devksh930.tabling.app.account.domain.Account;
import me.devksh930.tabling.app.account.domain.AccountValidator;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import me.devksh930.tabling.app.account.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountSignUpService {

    private final AccountRepository accountRepository;
    private final AccountValidator accountValidator;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String signUp(
        final AccountSignUpRequest request
    ) {
        final Account account = accountMapper.requestToEntity(request, passwordEncoder);
        accountValidator.validate(account);
        final Account save = accountRepository.save(account);

        return save.getEmail();
    }
}
