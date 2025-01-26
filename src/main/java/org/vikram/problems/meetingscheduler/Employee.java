package org.vikram.problems.meetingscheduler;

import java.util.List;

public class Employee implements Observer{
    private long empID;
    private String name;
    private Calendar calendar;

    public Employee(long empID, String name) {
        this.empID = empID;
        this.name = name;
        this.calendar = new Calendar();
    }

    @Override
    public void update(Meeting meeting) {
        System.out.println(this.name+ " invited to meeting by: "+meeting.getOrganiser()+ " in meeting room: "+meeting.getMeetingRoom().getId());
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<Meeting> getMeetings(){
        return this.calendar.getMeetingList();
    }

}
