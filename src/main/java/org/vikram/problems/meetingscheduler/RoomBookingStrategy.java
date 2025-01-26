package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RoomBookingStrategy {
    public Optional<MeetingRoom> getBookingRoom(int capacity, LocalDateTime startTime, LocalDateTime endTime);
}
