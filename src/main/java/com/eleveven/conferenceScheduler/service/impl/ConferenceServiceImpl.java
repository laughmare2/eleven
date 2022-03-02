package com.eleveven.conferenceScheduler.service.impl;

import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;
import org.springframework.stereotype.Service;

import static com.eleveven.conferenceScheduler.util.ConferenceUtil.*;
import static com.eleveven.conferenceScheduler.util.Constants.*;
import static com.eleveven.conferenceScheduler.util.ConferenceValidator.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private List<Meeting> unassignedMeetings;
    private List<Track> trackList;
    private Long trackCount;

    private List<Meeting> halfMeetings;
    private Long totalLength;
    private Long maxLengthInMinutes;

    @Override
    public List<Track> scheduleMeeting(List<Meeting> meetingList) throws Exception{
        validateMeetings(meetingList);
        initializeForSchedule(meetingList);
        createTrackList();
        createStartTimeForTracks();
        addNetworkingEventToTracks();
        return trackList;
    }

    void createTrackList(){
        while(unassignedMeetings.size() > 0){
            trackCount++;
            Track track = new Track();
            track.setTrackNo(trackCount);
            track.setFirstHalf(generateHalfOfTrack(unassignedMeetings, FIRST_HALF_MAX_LENGTH));
            track.setSecondHalf(generateHalfOfTrack(unassignedMeetings, SECOND_HALF_MAX_LENGTH));
            trackList.add(track);
        }
    }

    void createStartTimeForTracks(){
        for(Track track : trackList){
            createStartTimeForMeetings(track.getFirstHalf(), FIRST_HALF_START);
            createStartTimeForMeetings(track.getSecondHalf(), SECONDS_HALF_START);
        }
    }

    void createStartTimeForMeetings(List<Meeting> meetingList, Long startTime){
        for(Meeting meeting : meetingList){
            meeting.setStartTime(createStartTimeString(startTime));
            startTime += meeting.getLength();
        }
    }

    void addNetworkingEventToTracks(){
        for(Track track : trackList){
            Long totalLength = getTotalLengthOfMeetings(track.getSecondHalf());
            if(totalLength < SECOND_HALF_MAX_LENGTH){
                addNetworkingEventToTrack(track, totalLength);
            }
        }
    }

    void addNetworkingEventToTrack(Track track, Long totalLength){
        if(totalLength < NETWORKING_EVENT_EARLIEST_START){
            totalLength = NETWORKING_EVENT_EARLIEST_START;
        }
        addMeetingToList(createNetworkingEvent(totalLength), track.getSecondHalf());
    }

    Meeting createNetworkingEvent(Long totalLength){
        Long eventLength = SECOND_HALF_MAX_LENGTH - totalLength;
        String eventName = NETWORKING_EVENT_NAME;
        Long startTime = NETWORKING_EVENT_LATEST_END - eventLength;
        return new Meeting(eventName, eventLength, createStartTimeString(startTime));
    }

    List<Meeting> generateHalfOfTrack(List<Meeting> unassignedMeetings, Long length){
        initializeForTrackHalfGenerator(length);
        calculateHalfOfMeeting(totalLength, unassignedMeetings, halfMeetings);
        removeMeetingsFromList(halfMeetings, unassignedMeetings);
        return halfMeetings;
    }

    boolean calculateHalfOfMeeting(Long totalLength, List<Meeting> unassignedMeetings, List<Meeting> halfMeetings){
        if (addMeetingToHalf(totalLength,
                unassignedMeetings,
                halfMeetings)
        ) {
            return true;
        }else{
            if(maxLengthInMinutes == 0){
                return false;
            }
            maxLengthInMinutes -= LIGHTNING_LENGTH;
            totalLength = 0L;
            return calculateHalfOfMeeting(totalLength,
                    unassignedMeetings,
                    halfMeetings);
        }
    }

    boolean addMeetingToHalf(Long totalLength, List<Meeting> unassignedMeetings, List<Meeting> halfMeetings){
        for(Meeting meeting : unassignedMeetings){
            totalLength += meeting.getLength();
            if(checkEqual(totalLength , maxLengthInMinutes)){
                addMeetingToList(meeting, halfMeetings);
                return true;
            }else if (checkGreater(totalLength, maxLengthInMinutes)){
                return false;
            }else{
                if(addMeetingToHalf(totalLength,
                            removeMeetingFromListWithNewList(meeting, unassignedMeetings),
                            halfMeetings)
                ){
                    addMeetingToList(meeting, halfMeetings);
                    return true;
                }else{
                    totalLength -= meeting.getLength();
                    continue;
                }
            }
        }
        return false;
    }

    void initializeForSchedule(List<Meeting> meetingList){
        unassignedMeetings = new ArrayList<>(meetingList);
        trackList = new ArrayList<>();
        trackCount = 0L;
    }

    void initializeForTrackHalfGenerator(Long length){
        maxLengthInMinutes = length;
        halfMeetings = new ArrayList<>();
        totalLength = 0L;
    }

}
