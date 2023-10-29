package me.devksh930.tabling.app.auth.domain;

import java.util.Set;
import me.devksh930.tabling.app.common.domain.AccountId;
import me.devksh930.tabling.app.common.domain.Role;

public record AuthAccount(AccountId accountId,
                          String email,
                          String name,
                          String password,
                          String phone,
                          Set<Role> roles,
                          boolean emailVerified,
                          boolean phoneVerified

) {

}
