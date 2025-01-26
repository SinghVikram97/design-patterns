package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.Optional;

public class MeetingRoomFinder {
    private MeetingRoomFinder() {
    }

    public class MeetingRoomFinderHolder{
        private final static MeetingRoomFinder instance = new MeetingRoomFinder();
    }

    public static MeetingRoomFinder getMeetingRoomFinder(){
        return MeetingRoomFinderHolder.instance;
    }

    public MeetingRoom findMeetingRoom(int capacity, LocalDateTime startTime, LocalDateTime endTime, RoomBookingStrategy roomBookingStrategy) throws Exception {
        Optional<MeetingRoom> meetingRoom = roomBookingStrategy.getBookingRoom(capacity, startTime, endTime);
        if(meetingRoom.isPresent()){
            return meetingRoom.get();
        }else{
            throw new Exception("No meeting room available");
        }
    }
}
