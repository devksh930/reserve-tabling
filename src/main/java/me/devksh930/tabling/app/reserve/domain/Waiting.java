package me.devksh930.tabling.app.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
public class Waiting extends BaseTimeEntity {

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private Long storeId;

    @Enumerated(EnumType.STRING)
    private ReserveStatus status;

    private LocalDateTime reserveTime;

    private int people;

    public Waiting(
        final Long accountId,
        final Long storeId,
        final ReserveStatus status,
        final LocalDateTime reserveTime,
        final int people
    ) {
        this.accountId = accountId;
        this.storeId = storeId;
        this.status = status;
        this.reserveTime = reserveTime;
        this.people = people;
    }

    protected Waiting() {
    }


    public Long getAccountId() {
        return this.accountId;
    }

    public Long getStoreId() {
        return this.storeId;
    }

    public ReserveStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getReserveTime() {
        return this.reserveTime;
    }

    public int getPeople() {
        return this.people;
    }
}
