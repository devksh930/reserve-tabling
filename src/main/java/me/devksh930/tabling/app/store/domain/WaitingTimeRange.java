package me.devksh930.tabling.app.store.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
public class WaitingTimeRange extends BaseTimeEntity {
    @Embedded
    private TimeRange timeRange;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public WaitingTimeRange(
        final TimeRange timeRange,
        final Store store
    ) {
        this.timeRange = timeRange;
        this.store = store;
    }

    protected WaitingTimeRange() {
    }

    public TimeRange getTimeRange() {
        return this.timeRange;
    }

    public Store getStore() {
        return this.store;
    }
}
