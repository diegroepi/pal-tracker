package io.pivotal.pal.tracker;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TimeEntry {


    private long id;
    private long projectId;
    private long userId;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @NotNull
    private LocalDate date;
    private int hours;

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (!(obj instanceof TimeEntry))
            return false;
        TimeEntry timeEntry = (TimeEntry) obj;
        if (this.id != timeEntry.getId())
            return false;
        if (this.projectId != timeEntry.getProjectId())
            return false;
        if (this.userId != timeEntry.getUserId())
            return false;
        if (this.hours != timeEntry.getHours())
            return false;
        if (!this.date.isEqual(timeEntry.getDate()))
            return false;
        return true;
    }
}
