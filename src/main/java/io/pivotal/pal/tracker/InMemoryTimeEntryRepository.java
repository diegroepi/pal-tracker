package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long nextId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(nextId);
        nextId++;
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry updatedTimeEntry) {

        TimeEntry existingTimeEntry = timeEntries.get(id);
        if (existingTimeEntry != null) {
            updatedTimeEntry.setId(id);
            timeEntries.replace(id, existingTimeEntry, updatedTimeEntry);
            return updatedTimeEntry;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(timeEntries.values());

    }
}
