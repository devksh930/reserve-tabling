package me.devksh930.tabling.app.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @Email String email,
    @NotBlank String password) {

}
