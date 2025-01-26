package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingScheduler {
    private MeetingScheduler(){
    }

    private static class MeetingSchedulerInstanceHolder{
        private static final MeetingScheduler meetingScheduler = new MeetingScheduler();
    }

    public static MeetingScheduler getMeetingScheduler(){
        return MeetingSchedulerInstanceHolder.meetingScheduler;
    }

    public long createMeeting(Employee organiser, LocalDateTime startTime, LocalDateTime endTime, List<Employee> participants, MeetingRoom meetingRoom) {
        // 1. Create a meeting
        Meeting meeting = new Meeting(startTime, endTime, organiser);

        // 2. Add participants to the meeting
        participants.forEach(meeting::addObserver);

        // 3. Book the room
        meetingRoom.bookRoom(meeting);

        // 4. Add room details in the meeting
        meeting.addMeetingRoom(meetingRoom);

        // 5. Send notification to all the participants
        // Here participants are observers and meetings are observable
        meeting.update();

        // 6. Add meeting to their calendars
        participants.forEach(participant -> participant.getCalendar().addMeeting(meeting));

        // 7. Add to organiser's calendar
        organiser.getCalendar().addMeeting(meeting);

        return meeting.getMeetingID();
    }
}
