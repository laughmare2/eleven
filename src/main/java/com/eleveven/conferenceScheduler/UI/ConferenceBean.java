package com.eleveven.conferenceScheduler.UI;

import com.eleveven.conferenceScheduler.model.Length;
import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;
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

    private static final long serialVersionUID = 4085285875380136779L;

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
        meetingList.add(meeting);
    }

    public void removeMeeting(Meeting meeting){
        meetingList.remove(meeting);
    }

    public void createSchedule(){
        schedule = conferenceService.scheduleMeeting(meetingList);
    }

    public void initLengthList(){
        lengthList = new ArrayList<>();
        Long lengthValue = 5L;
        lengthList.add(new Length("Lightning", lengthValue));
        while(lengthValue < 60){
            lengthValue += 5L;
            lengthList.add(new Length(lengthValue + " Min", lengthValue));
        }
    }

    public void setMeetingsFromJson(){
        Type meetingListType = new TypeToken<List<Meeting>>() {}.getType();
        meetingList = new Gson().fromJson(json, meetingListType);
    }
}
