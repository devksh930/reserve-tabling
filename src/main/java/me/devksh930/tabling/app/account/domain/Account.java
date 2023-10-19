package me.devksh930.tabling.app.account.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
public class Account extends BaseTimeEntity {

    @Embedded
    private AccountId accountId;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    @Column(unique = true)
    private String phone;

    private boolean emailVerified;

    private boolean phoneVerified;

    public Account(
        final String email,
        final String name,
        final String password,
        final String phone,
        final boolean emailVerified,
        final boolean phoneVerified
    ) {
        this.accountId = AccountId.create();
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
    }

    protected Account() {
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }
}
