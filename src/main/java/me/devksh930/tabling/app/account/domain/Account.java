package me.devksh930.tabling.app.account.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {

    @EmbeddedId
    @AttributeOverride(name = "value",
        column = @Column(name = "id"))
    private AccountId id;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    @Column(unique = true)
    private String phone;

    private boolean emailVerified;

    private boolean phoneVerified;

    @Builder
    public Account(
        final String email,
        final String name,
        final String password,
        final String phone,
        final boolean emailVerified,
        final boolean phoneVerified
    ) {
        this.id = AccountId.create();
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
    }
}
