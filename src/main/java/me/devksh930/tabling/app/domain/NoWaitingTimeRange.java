package me.devksh930.tabling.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoWaitingTimeRange extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public NoWaitingTimeRange(
        final Long id,
        final LocalDateTime startTime,
        final LocalDateTime endTime,
        final Store store
    ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.store = store;
    }
}
