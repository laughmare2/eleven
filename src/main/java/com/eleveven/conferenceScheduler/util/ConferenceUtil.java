package com.eleveven.conferenceScheduler.util;

import com.eleveven.conferenceScheduler.model.Meeting;

import static com.eleveven.conferenceScheduler.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class ConferenceUtil {

    public static boolean checkEqual(Long long1, Long long2){
        return long1.equals(long2);
    }

    public static boolean checkGreater(Long long1, Long long2){
        return long1 > long2;
    }

    public static List<Meeting> removeMeetingFromListWithNewList(Meeting meeting, List<Meeting> meetingList){
        List<Meeting> meetingsWithRemovedObject = new ArrayList<>(meetingList);
        removeMeetingFromList(meeting, meetingsWithRemovedObject);
        return meetingsWithRemovedObject;
    }

    public static void removeMeetingFromList(Meeting meeting, List<Meeting> meetingList){
        meetingList.remove(meeting);
    }

    public static void removeMeetingsFromList(List<Meeting> meetingsToBeRemoved, List<Meeting> meetingList){
        meetingList.removeAll(meetingsToBeRemoved);
    }

    public static void addMeetingToList(Meeting meeting, List<Meeting> meetingList){
        meetingList.add(meeting);
    }

    public static Long getTotalLengthOfMeetings(List<Meeting> meetingList){
        Long totalLength = 0L;
        for(Meeting meeting : meetingList){
            totalLength += meeting.getLength();
        }
        return totalLength;
    }

    public static String createStartTimeString(Long startTime){
        boolean isPM = false;
        int hour = (int) (startTime / MINUTES_IN_AN_HOUR) + STARTING_HOUR;
        int minute = (int) (startTime % MINUTES_IN_AN_HOUR);
        String startTimeString = "";
        if(hour > 12){
            hour -= 12;
            isPM = true;
        }
        if(hour < 10){
            startTimeString += 0;
        }
        startTimeString += hour + ":";
        if(minute < 10){
            startTimeString += 0;
        }
        startTimeString += minute;
        if(isPM){
            startTimeString += POST_MERIDIEM;
        }else{
            startTimeString += ANTE_MERIDIEM;
        }
        return startTimeString;
    }
}
