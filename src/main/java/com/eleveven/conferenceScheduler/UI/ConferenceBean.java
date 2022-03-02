package com.eleveven.conferenceScheduler.UI;

import com.eleveven.conferenceScheduler.model.Length;
import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;
import static com.eleveven.conferenceScheduler.util.Constants.*;
import static com.eleveven.conferenceScheduler.util.ConferenceUtil.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean(name = "conferenceBean")
@ViewScoped
@Getter
@Setter
public class ConferenceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    public ConferenceService conferenceService;

    public List<Meeting> meetingList;
    public List<Track> schedule;
    public String name;
    public Long length;
    public List<Length> lengthList;
    public String json;

    @PostConstruct
    public void init() {
        meetingList = new ArrayList<>();
        schedule = new ArrayList<>();
        initLengthList();
    }

    public void addMeeting(){
        Meeting meeting = new Meeting();
        meeting.setLength(length);
        meeting.setName(name);
        addMeetingToList(meeting, meetingList);
    }

    public void removeMeeting(Meeting meeting){
        removeMeetingFromList(meeting, meetingList);
    }

    public void createSchedule(){
        schedule = conferenceService.scheduleMeeting(meetingList);
    }

    public void initLengthList(){
        lengthList = new ArrayList<>();
        Long lengthValue = LIGHTNING_LENGTH;
        lengthList.add(new Length(LIGHTNING, lengthValue));
        while(lengthValue < MINUTES_IN_AN_HOUR){
            lengthValue += LIGHTNING_LENGTH;
            lengthList.add(new Length(lengthValue + MINUTE, lengthValue));
        }
    }

    public void setMeetingsFromJson(){
        Type meetingListType = new TypeToken<List<Meeting>>() {}.getType();
        meetingList = new Gson().fromJson(json, meetingListType);
    }
}
