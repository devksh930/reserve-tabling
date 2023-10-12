package me.devksh930.tabling.app.account.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountSignUpRequest {

    private String email;
    private String name;
    private String password;
    private String phone;

    public AccountSignUpRequest(String email,
        String name,
        String password,
        String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
}
