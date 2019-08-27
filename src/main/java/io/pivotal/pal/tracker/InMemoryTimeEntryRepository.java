package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository{

    List<TimeEntry> timeEntries = new ArrayList<>();
    private long count;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        count++;
        timeEntry.setId(count);
        timeEntries.add(timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry timeEntry =null;
        for(TimeEntry timeEntry1:timeEntries){
            if(timeEntry1.getId()==id){
                timeEntry=timeEntry1;
            }
        }
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updatedEntry=null;
        for(TimeEntry timeEntryOld :timeEntries){
            if(timeEntryOld.getId()==id){
                updatedEntry = updateTimeEntryParams(timeEntry, timeEntryOld);
                break;
            }
        }


        return updatedEntry;
    }

    private TimeEntry updateTimeEntryParams(TimeEntry timeEntry, TimeEntry timeEntryOld) {
        timeEntryOld.setProjectId(timeEntry.getProjectId());
        timeEntryOld.setHours(timeEntry.getHours());
        timeEntryOld.setDate(timeEntry.getDate());
        timeEntryOld.setHours(timeEntry.getHours());
        timeEntryOld.setUserId(timeEntry.getUserId());
        timeEntryOld.setTimeEntryId(timeEntry.getTimeEntryId());
        return timeEntryOld;
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntries.clear();
    }
}
