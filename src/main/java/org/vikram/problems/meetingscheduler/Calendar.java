package org.vikram.problems.meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final List<Meeting> meetingList;

    public Calendar() {
        this.meetingList = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        meetingList.add(meeting);
    }

    public void removeMeeting(Meeting meeting){
        meetingList.remove(meeting);
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }
}
