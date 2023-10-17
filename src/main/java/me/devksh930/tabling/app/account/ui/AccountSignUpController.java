package me.devksh930.tabling.app.account.ui;

import jakarta.validation.Valid;
import java.net.URI;
import me.devksh930.tabling.app.account.application.AccountSignUpService;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountSignUpController {

    private final AccountSignUpService accountSignUpService;

    public AccountSignUpController(
        final AccountSignUpService accountSignUpService
    ) {
        this.accountSignUpService = accountSignUpService;
    }

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody final AccountSignUpRequest request) {
        accountSignUpService.signUp(request);
        return ResponseEntity.created(URI.create("/accounts/me")).build();
    }

}
