package com.eleveven.conferenceScheduler.util;

import com.eleveven.conferenceScheduler.model.Meeting;

import java.util.List;

public class ConferenceValidator {

    public static void validateMeeting(Meeting meeting) throws Exception{
        if(meeting == null){
            throw new Exception("Meeting cant be null");
        }
        if(meeting.getName() == null || meeting.getName().trim().isEmpty()){
            throw new Exception("Meeting name cant be empty");
        }
        if(meeting.getLength() == null || meeting.getLength() % 5 != 0){
            throw new Exception("Meeting length must be multiple of 5");
        }
    }

    public static void validateMeetings(List<Meeting> meetingList) throws Exception{
        for(Meeting meeting : meetingList){
            validateMeeting(meeting);
        }
    }
}
