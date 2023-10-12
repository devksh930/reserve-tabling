package me.devksh930.tabling.app.account.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountSignUpRequest {

    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    public AccountSignUpRequest(
        String email,
        String name,
        String password,
        String phone
    ) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
}
