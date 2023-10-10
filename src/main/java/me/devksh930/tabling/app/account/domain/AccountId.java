package me.devksh930.tabling.app.account.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountId implements Serializable {

    private String accountId;

    private AccountId(final String accountId) {
        this.accountId = accountId;
    }

    public static AccountId of(final String uuid) {
        return new AccountId(uuid);
    }

    public static AccountId create() {
        return new AccountId(UUID.randomUUID().toString());
    }
}
