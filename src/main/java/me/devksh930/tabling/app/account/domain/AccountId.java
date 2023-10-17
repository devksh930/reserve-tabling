package me.devksh930.tabling.app.account.domain;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountId implements Serializable {

    @Column(name = "account_id")
    private String value;

    private AccountId(String uuid) {
        this.value = uuid;
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
}