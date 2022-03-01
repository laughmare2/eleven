package com.eleveven.conferenceScheduler.controller;

import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ConferenceController {

    @Autowired
    ConferenceService conferenceService;

    @GetMapping("/scheduleMeeting")
    List<Track> scheduleMeeting(@RequestBody List<Meeting> meetingList) {
        return conferenceService.scheduleMeeting(meetingList);
    }

}
