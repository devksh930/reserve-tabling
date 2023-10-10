package me.devksh930.tabling.app.store.domain;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
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
}
