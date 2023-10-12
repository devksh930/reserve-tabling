package me.devksh930.tabling.app.account.ui;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import me.devksh930.tabling.app.account.application.AccountSignUpService;
import me.devksh930.tabling.app.account.dto.request.AccountSignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountSignUpController {

    private final AccountSignUpService accountSignUpService;

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody AccountSignUpRequest request) {
        accountSignUpService.signUp(request);
        return ResponseEntity.created(URI.create("/accounts/me")).build();
    }

}
