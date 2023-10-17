package me.devksh930.tabling.app.store.domain;

import java.time.LocalDateTime;

public class TimeRange {

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public TimeRange(
        final LocalDateTime startDateTime,
        final LocalDateTime endDateTime
    ) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public boolean rangeInTime(
        final LocalDateTime time
    ) {
        return startDateTime.isAfter(time) &&
            endDateTime.isBefore(time);
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }
}
