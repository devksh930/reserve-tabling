package me.devksh930.tabling.app.auth.dto.respone;

public record TokenResponse(
    String accessToken,
    String refreshToken,
    long accessTokenValidityInMilliseconds,
    long refreshTokenValidityInMilliseconds) {

}
