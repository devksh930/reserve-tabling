package me.devksh930.tabling.app.account.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AccountSignUpRequest(
    @Email String email,
    @NotBlank String name,
    @NotBlank String password,
    @NotBlank String phone
) {

}
