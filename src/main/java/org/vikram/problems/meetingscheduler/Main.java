package org.vikram.problems.meetingscheduler;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create users
        Employee vikram = new Employee(123, "Vikram");
        Employee apoorv = new Employee(124, "Apoorv");
        Employee saksham = new Employee(125, "Saksham");
        Employee anirudh = new Employee(126, "Anirudh");
        Employee aryan = new Employee(127, "Aryan");

        // Create meeting rooms
        Building.getBuilding().addMeetingRoom(new MeetingRoom(2, 1));
        Building.getBuilding().addMeetingRoom(new MeetingRoom(3, 2));
        Building.getBuilding().addMeetingRoom(new MeetingRoom(4, 3));
        Building.getBuilding().addMeetingRoom(new MeetingRoom(5, 4));


        // Vikram looks for a meeting room for meeting 1 b/w 4:30pm to 5:30pm
        LocalDateTime startTime1 = LocalDateTime.of(2025, 1, 15, 16, 30);
        LocalDateTime endTime1 = LocalDateTime.of(2025, 1, 15, 17, 30);
        MeetingRoom meetingRoom1 = MeetingRoomFinder.getMeetingRoomFinder()
                .findMeetingRoom(3, startTime1, endTime1, FirstAvailableRoomStrategy.getFirstAvailableRoomStrategy());

        MeetingScheduler.getMeetingScheduler()
                .createMeeting(
                        vikram,
                        startTime1,
                        endTime1,
                        List.of(apoorv, saksham),
                        meetingRoom1
                );

        // Vikram looks for a meeting room for meeting 2 b/w 4pm to 5pm
        LocalDateTime startTime2 = LocalDateTime.of(2025, 1, 15, 16, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2025, 1, 15, 17, 0);
        MeetingRoom meetingRoom2 = MeetingRoomFinder.getMeetingRoomFinder()
                .findMeetingRoom(3, startTime2, endTime2, FirstAvailableRoomStrategy.getFirstAvailableRoomStrategy());

        MeetingScheduler.getMeetingScheduler()
                .createMeeting(
                        vikram,
                        LocalDateTime.of(2025, 1, 15, 16, 0),
                        LocalDateTime.of(2025, 1, 15, 17, 0),
                        List.of(aryan, anirudh),
                        meetingRoom2
                );

        System.out.println("\nVikram has these meetings ");
        vikram.getMeetings().forEach(System.out::println);
    }
}
