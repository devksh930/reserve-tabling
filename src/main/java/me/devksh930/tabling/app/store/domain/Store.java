package me.devksh930.tabling.app.store.domain;

import jakarta.persistence.Entity;
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
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime openDate;

    private LocalDateTime endDate;

    @Builder
    public Store(
        final Long id,
        final String name,
        final String description,
        final LocalDateTime openDate,
        final LocalDateTime endDate
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openDate = openDate;
        this.endDate = endDate;
    }
}
