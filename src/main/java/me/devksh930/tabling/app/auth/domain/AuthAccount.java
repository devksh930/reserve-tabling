package me.devksh930.tabling.app.auth.domain;

import me.devksh930.tabling.app.account.domain.AccountId;

public record AuthAccount(AccountId accountId,
                          String email,
                          String name,
                          String password,
                          String phone,
                          boolean emailVerified,
                          boolean phoneVerified

) {

}
