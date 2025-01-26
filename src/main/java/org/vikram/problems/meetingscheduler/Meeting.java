package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Meeting implements Observable{
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Employee organiser;

    private List<Observer> participantList;

    private MeetingRoom meetingRoom;

    private long meetingID;

    public Meeting(LocalDateTime startTime, LocalDateTime endTime, Employee organiser) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingID = new Random().nextLong(10, 500);
        this.participantList = new ArrayList<>();
        this.organiser = organiser;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        this.meetingRoom = meetingRoom;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<Observer> getParticipantList() {
        return participantList;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public long getMeetingID() {
        return meetingID;
    }

    public Employee getOrganiser() {
        return organiser;
    }

    @Override
    // same as add participant
    public void addObserver(Observer observer) {
        this.participantList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.participantList.remove(observer);
    }

    @Override
    public void update() {
        participantList.forEach(participant -> participant.update(this));
    }

    @Override
    public String toString() {
        return "Meeting ID: "+this.getMeetingID()+" meeting room: "+this.meetingRoom.getId()+ " from "+this.startTime + " to "+this.endTime;
    }
}
