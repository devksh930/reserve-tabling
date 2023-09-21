package me.devksh930.tabling.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;

    private String phone;

    private boolean emailVerified;

    private boolean phoneVerified;

    @Column(unique = true, nullable = false)
    private AccountId accountId;

    @Builder
    public Account(
        final Long id,
        final String email,
        final String name,
        final String password,
        final String phone,
        final boolean emailVerified,
        final boolean phoneVerified
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
        this.accountId = AccountId.create();
    }
}
