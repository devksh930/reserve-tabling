package me.devksh930.tabling.app.store.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoWaitingTimeRange extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TimeRange timeRange;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public NoWaitingTimeRange(
        final Long id,
        final TimeRange timeRange,
        final Store store
    ) {
        this.id = id;
        this.timeRange = timeRange;
        this.store = store;
    }
}
