package com.eleveven.conferenceScheduler.controller;

import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ConferenceController {

    @Autowired
    ConferenceService conferenceService;

    @GetMapping("/scheduleMeeting")
    List<Track> scheduleMeeting(@RequestBody List<Meeting> meetingList) throws Exception{
        return conferenceService.scheduleMeeting(meetingList);
    }


}
