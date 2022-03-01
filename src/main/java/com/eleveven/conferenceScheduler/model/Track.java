package com.eleveven.conferenceScheduler.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Track implements Serializable {
    Long trackNo;
    List<Meeting> firstHalf;
    List<Meeting> secondHalf;
}
