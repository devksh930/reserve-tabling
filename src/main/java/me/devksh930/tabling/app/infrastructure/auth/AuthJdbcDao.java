package me.devksh930.tabling.app.infrastructure.auth;

import java.util.Optional;
import me.devksh930.tabling.app.account.domain.AccountId;
import me.devksh930.tabling.app.auth.domain.AuthAccount;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthJdbcDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthJdbcDao(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Optional<AuthAccount> selectByEmail(final String email) {
        final String sql = "SELECT * FROM account WHERE email = :email";

        final MapSqlParameterSource params = new MapSqlParameterSource("email", email);
        return Optional.ofNullable(
            namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper()));
    }

    private RowMapper<AuthAccount> rowMapper() {
        return (rs, rowNum) -> new AuthAccount(
            AccountId.of(rs.getString("account_uuid")),
            rs.getString("email"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getString("phone"),
            rs.getBoolean("email_verified"),
            rs.getBoolean("phone_verified"));
    }

}
