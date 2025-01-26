package org.vikram.problems.meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<MeetingRoom> meetingRoomList;

    private Building(){
        meetingRoomList = new ArrayList<>();
    }

    public static class BuildingHolder{
        private static final Building building = new Building();
    }

    public List<MeetingRoom> getMeetingRoomList() {
        return meetingRoomList;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        this.meetingRoomList.add(meetingRoom);
    }

    public static Building getBuilding(){
        return BuildingHolder.building;
    }
}
