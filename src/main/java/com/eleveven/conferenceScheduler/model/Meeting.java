package com.eleveven.conferenceScheduler.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Meeting implements Serializable {

    String name;
    Long length;
    String startTime;

}
