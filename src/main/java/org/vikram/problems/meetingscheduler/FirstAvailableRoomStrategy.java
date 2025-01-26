package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.Optional;

public class FirstAvailableRoomStrategy implements RoomBookingStrategy{
    private FirstAvailableRoomStrategy() {

    }

    public class FirstAvailableRoomStrategyHolder{
        private static final FirstAvailableRoomStrategy instance = new FirstAvailableRoomStrategy();
    }

    public static FirstAvailableRoomStrategy getFirstAvailableRoomStrategy(){
        return FirstAvailableRoomStrategyHolder.instance;
    }

    @Override
    public Optional<MeetingRoom> getBookingRoom(int capacity, LocalDateTime startTime, LocalDateTime endTime) {

        return Building.getBuilding().getMeetingRoomList().stream().filter(meetingRoom -> !isMeetingRoomBooked(meetingRoom, startTime, endTime) && meetingRoom.getCapacity() >= capacity).findFirst();
    }

    private boolean isMeetingRoomBooked(MeetingRoom meetingRoom, LocalDateTime startTime1, LocalDateTime endTime1){
        for(Meeting meeting: meetingRoom.getMeetings()){
            LocalDateTime startTime2 = meeting.getStartTime();
            LocalDateTime endTime2 = meeting.getEndTime();

            // Overlap
            if(startTime1.isBefore(startTime2) && startTime2.isBefore(endTime1)){
                return true;
            }else if(startTime2.isBefore(startTime1) && startTime1.isBefore(endTime2)){
                return true;
            }else if(startTime1.isEqual(startTime2)){
                return true;
            }
        }
        return false; // No overlap
    }
}
