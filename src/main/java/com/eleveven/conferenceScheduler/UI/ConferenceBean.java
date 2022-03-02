package com.eleveven.conferenceScheduler.UI;

import com.eleveven.conferenceScheduler.model.Length;
import com.eleveven.conferenceScheduler.model.Meeting;
import com.eleveven.conferenceScheduler.model.Track;
import com.eleveven.conferenceScheduler.service.ConferenceService;
import static com.eleveven.conferenceScheduler.util.Constants.*;
import static com.eleveven.conferenceScheduler.util.ConferenceUtil.*;
import static com.eleveven.conferenceScheduler.util.ConferenceValidator.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
        try {
            Meeting meeting = new Meeting();
            meeting.setLength(length);
            meeting.setName(name);
            validateMeeting(meeting);
            addMeetingToList(meeting, meetingList);
        }catch(Exception e){
            addMessage(FacesMessage.SEVERITY_ERROR, ERROR_SUMMARY, e.getMessage());
        }
    }

    public void removeMeeting(Meeting meeting){
        removeMeetingFromList(meeting, meetingList);
    }

    public void createSchedule() {
        try{
            schedule = conferenceService.scheduleMeeting(meetingList);
        } catch(Exception e){
            addMessage(FacesMessage.SEVERITY_ERROR, ERROR_SUMMARY, e.getMessage());
        }
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
        try{
            Type meetingListType = new TypeToken<List<Meeting>>() {}.getType();
            meetingList = new Gson().fromJson(json, meetingListType);
        }catch (Exception e){
            addMessage(FacesMessage.SEVERITY_ERROR, ERROR_SUMMARY, e.getMessage());
        }
    }

    public void copyJsonTemplateToClipboard(){
        copyToClipboard(JSON_TEMPLATE);
        addMessage(FacesMessage.SEVERITY_INFO, CLIPBOARD_SUMMARY, CLIPBOARD_MESSAGE);

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
