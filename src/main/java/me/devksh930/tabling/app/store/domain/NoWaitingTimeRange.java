package me.devksh930.tabling.app.store.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
public class NoWaitingTimeRange extends BaseTimeEntity {

    @Embedded
    private TimeRange timeRange;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public NoWaitingTimeRange(
        final TimeRange timeRange,
        final Store store
    ) {
        this.timeRange = timeRange;
        this.store = store;
    }

    protected NoWaitingTimeRange() {
    }

    public TimeRange getTimeRange() {
        return this.timeRange;
    }

    public Store getStore() {
        return this.store;
    }

}
