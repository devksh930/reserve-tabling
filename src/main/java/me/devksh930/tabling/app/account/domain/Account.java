package me.devksh930.tabling.app.account.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import java.util.Set;
import me.devksh930.tabling.app.common.config.RolesConverter;
import me.devksh930.tabling.app.common.domain.AccountId;
import me.devksh930.tabling.app.common.domain.Role;
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

    @Column(name = "roles")
    @Convert(converter = RolesConverter.class)
    private Set<Role> roles;

    private boolean emailVerified;

    private boolean phoneVerified;

    public Account(
        final String email,
        final String name,
        final String password,
        final String phone,
        final Set<Role> roles,
        final boolean emailVerified,
        final boolean phoneVerified
    ) {
        this.roles = roles;
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


    public Set<Role> getRoles() {
        return roles;
    }
}
