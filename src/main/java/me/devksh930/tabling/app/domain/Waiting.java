package me.devksh930.tabling.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Waiting extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private Long storeId;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;

    @Builder
    public Waiting(
        final Long id,
        final Long accountId,
        final Long storeId,
        final ReserveStatus reserveStatus
    ) {
        this.id = id;
        this.accountId = accountId;
        this.storeId = storeId;
        this.reserveStatus = reserveStatus;
    }
}
