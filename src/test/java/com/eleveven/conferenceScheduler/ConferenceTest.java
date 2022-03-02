package com.eleveven.conferenceScheduler;

import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ConferenceTest {

    @Autowired
    public ConferenceService conferenceService;

    @Test
    public void conferenceTest() throws Exception{
        List<Track> schedule = conferenceService.scheduleMeeting(createMeetingList());
        assertEquals(schedule, createTrackResult());
    }

    List<Meeting> createMeetingList(){
        List<Meeting> meetingList = new ArrayList<>();
        String meetingName;
        Long length = 60L;
        for(int i=1; i<=10;i++){
            meetingName = "Meeting" + i;
            Meeting meeting = new Meeting();
            meeting.setName(meetingName);
            meeting.setLength(length);
            meetingList.add(meeting);
        }
        return meetingList;
    }

    List<Track> createTrackResult(){
        List<Track> trackList = new ArrayList<>();

        Track track1 = new Track();

        track1.setTrackNo(1L);

        Meeting meeting3 = new Meeting("Meeting3", 60L, "09:00AM");
        Meeting meeting2 = new Meeting("Meeting2", 60L, "10:00AM");
        Meeting meeting1 = new Meeting("Meeting1", 60L, "11:00AM");

        List<Meeting> track1FH = new ArrayList<>();

        track1FH.add(meeting3);
        track1FH.add(meeting2);
        track1FH.add(meeting1);
        track1.setFirstHalf(track1FH);

        Meeting meeting7 = new Meeting("Meeting7", 60L, "01:00PM");
        Meeting meeting6 = new Meeting("Meeting6", 60L, "02:00PM");
        Meeting meeting5 = new Meeting("Meeting5", 60L, "03:00PM");
        Meeting meeting4 = new Meeting("Meeting4", 60L, "04:00PM");

        List<Meeting> track1SH = new ArrayList<>();

        track1SH.add(meeting7);
        track1SH.add(meeting6);
        track1SH.add(meeting5);
        track1SH.add(meeting4);
        track1.setSecondHalf(track1SH);

        trackList.add(track1);

        Track track2 = new Track();

        track2.setTrackNo(2L);

        Meeting meeting10 = new Meeting("Meeting10", 60L, "09:00AM");
        Meeting meeting9 = new Meeting("Meeting9", 60L, "10:00AM");
        Meeting meeting8 = new Meeting("Meeting8", 60L, "11:00AM");

        List<Meeting> track2FH = new ArrayList<>();

        track2FH.add(meeting10);
        track2FH.add(meeting9);
        track2FH.add(meeting8);
        track2.setFirstHalf(track2FH);

        Meeting networkingEvent = new Meeting("Networking Event", 60L, "04:00PM");

        List<Meeting> track2SH = new ArrayList<>();

        track2SH.add(networkingEvent);
        track2.setSecondHalf(track2SH);

        trackList.add(track2);

        return trackList;
    }
}
