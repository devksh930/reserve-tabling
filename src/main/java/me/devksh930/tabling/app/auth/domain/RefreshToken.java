package me.devksh930.tabling.app.auth.domain;

import java.util.concurrent.TimeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "refresh_token")
public class RefreshToken {

    @Id
    private String accountUUID;

    @Indexed
    private String value;

    @TimeToLive(unit = TimeUnit.MILLISECONDS)
    private long timeOut;

    public RefreshToken(
        final String accountUUID,
        final String value,
        final long timeOut
    ) {
        this.accountUUID = accountUUID;
        this.value = value;
        this.timeOut = timeOut;
    }

    public String getAccountUUID() {
        return accountUUID;
    }

    public String getValue() {
        return value;
    }

    public long getTimeOut() {
        return timeOut;
    }
}
