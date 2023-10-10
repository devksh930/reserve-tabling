package me.devksh930.tabling.app.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Waiting extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private Long storeId;

    @Enumerated(EnumType.STRING)
    private ReserveStatus status;

    private LocalDateTime reserveTime;

    private int people;

    @Builder
    public Waiting(
        final Long id,
        final Long accountId,
        final Long storeId,
        final ReserveStatus status,
        final LocalDateTime reserveTime,
        final int people
    ) {
        this.id = id;
        this.accountId = accountId;
        this.storeId = storeId;
        this.status = status;
        this.reserveTime = reserveTime;
        this.people = people;
    }
}
