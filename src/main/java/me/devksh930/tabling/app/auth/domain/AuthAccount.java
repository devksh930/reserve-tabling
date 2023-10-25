package me.devksh930.tabling.app.auth.domain;

import me.devksh930.tabling.app.common.domain.AccountId;

public record AuthAccount(AccountId accountId,
                          String email,
                          String name,
                          String password,
                          String phone,
                          boolean emailVerified,
                          boolean phoneVerified

) {

}
