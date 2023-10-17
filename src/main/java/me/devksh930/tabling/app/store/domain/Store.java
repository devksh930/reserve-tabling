package me.devksh930.tabling.app.store.domain;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import me.devksh930.tabling.app.common.entity.BaseTimeEntity;

@Entity
public class Store extends BaseTimeEntity {

    private String name;

    private String description;

    private LocalDateTime openDate;

    private LocalDateTime endDate;

    public Store(
        final String name,
        final String description,
        final LocalDateTime openDate,
        final LocalDateTime endDate
    ) {
        this.name = name;
        this.description = description;
        this.openDate = openDate;
        this.endDate = endDate;
    }

    protected Store() {
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getOpenDate() {
        return this.openDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

}
