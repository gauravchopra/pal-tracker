package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.
                create(timeEntryToCreate);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(timeEntry,timeEntry!=null?HttpStatus.CREATED:HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable (value = "id") long id) {

        TimeEntry timeEntry = timeEntryRepository.
                find(id);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(timeEntry,timeEntry!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<TimeEntry> update(@PathVariable (value = "id") long timeEntryId,@RequestBody TimeEntry expected) {

        TimeEntry timeEntry = timeEntryRepository.
                update(timeEntryId,expected);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(timeEntry,timeEntry!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<TimeEntry> delete(@PathVariable (value = "id") long timeEntryId) {
        timeEntryRepository.
                delete(timeEntryId);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TimeEntry>> list() {
        ResponseEntity<List<TimeEntry>> responseEntity = new ResponseEntity<>(timeEntryRepository.list(),HttpStatus.OK);
        return  responseEntity;
    }
}
