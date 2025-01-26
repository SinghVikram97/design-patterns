package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private final int capacity;
    private final List<Meeting> meetings;

    private final long id;

    public MeetingRoom(int capacity, int id) {
        this.capacity = capacity;
        this.id = id;
        this.meetings = new ArrayList<>();
    }

    public void bookRoom(Meeting meeting){
        this.meetings.add(meeting);
    }

    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
