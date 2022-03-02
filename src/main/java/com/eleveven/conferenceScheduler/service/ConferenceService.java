package com.eleveven.conferenceScheduler.service;

import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;

import java.util.List;

public interface ConferenceService{

    List<Track> scheduleMeeting(List<Meeting> meetingList) throws Exception;

}
