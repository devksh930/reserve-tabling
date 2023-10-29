package me.devksh930.tabling.app.infrastructure.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.Optional;
import me.devksh930.tabling.app.auth.domain.AuthAccount;
import me.devksh930.tabling.app.common.domain.AccountId;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthJdbcDao {

    private static final JsonMapper mapper = JsonMapper.builder()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
        .build();
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
        return (rs, rowNum) ->
        {
            try {
                return new AuthAccount(
                    AccountId.of(rs.getString("account_uuid")),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    mapper.readValue(rs.getString("roles"), new TypeReference<>() {}),
                    rs.getBoolean("email_verified"),
                    rs.getBoolean("phone_verified"));

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}


