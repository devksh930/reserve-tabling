package me.devksh930.tabling.app.auth.application;

import java.util.List;
import me.devksh930.tabling.app.auth.domain.AuthAccount;
import me.devksh930.tabling.app.auth.domain.AuthRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public CustomUserDetailsService(
        final AuthRepository authRepository
    ) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

        return authRepository.findByEmail(email)
            .map(this::toUserDetails)
            .orElseThrow(()->new RuntimeException("존재하지 않음"));
    }

    public UserDetails toUserDetails(final AuthAccount authAccount) {
        List<SimpleGrantedAuthority> list = authAccount.roles().stream()
            .map(s -> new SimpleGrantedAuthority("ROLE_" + s)).toList();
        return User.builder()
            .username(authAccount.accountId().getValue())
            .password(authAccount.password())
            .authorities(list)
            .build();
    }

}
