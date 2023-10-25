package me.devksh930.tabling.app.account.domain;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountId implements Serializable {

    @Column(name = "account_uuid")
    private String value;

    private AccountId(String uuid) {
        this.value = uuid;
    }

    protected AccountId() {
    }

    public static AccountId create() {
        return new AccountId(
            Generators
                .timeBasedEpochGenerator()
                .generate()
                .toString()
        );
    }

    public static AccountId of(String uuid) {
        return new AccountId(uuid);
    }

    public String getValue() {
        return this.value;
    }
}
